class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length <= nums[0])
            return length;
        for (int x = 1; x < length; x++) {
            if (nums[length - x] >= x && nums[length - x - 1] < x)
                return x;
        }
        return -1;
    }
}