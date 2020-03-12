class Solution {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return k;
        int length = nums.length;
        if (k >= nums[length - 1])
            return k + nums[0] + length - 1;
        int num = nums[0];
        int index = 1;
        while (index < length && k > 0) {
            num++;
            if (num == nums[index])
                index++;
            else
                k--;
        }
        return num + k;
    }
}