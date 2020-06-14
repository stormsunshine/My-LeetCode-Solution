class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length];
        sums[0] = nums[0];
        for (int i = 1; i < length; i++)
            sums[i] = sums[i - 1] + nums[i];
        return sums;
    }
}