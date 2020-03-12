class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int length = nums.length;
        if (length == 1)
            return nums[0] == 1 ? 2 : 1;
        boolean existOne = false;
        for (int num : nums) {
            if (num == 1) {
                existOne = true;
                break;
            }
        }
        if (!existOne)
            return 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0 || nums[i] > length)
                nums[i] = -1;
            else
                nums[i] = -nums[i];
        }
        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]);
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0)
                return i + 1;
        }
        return length + 1;
    }
}