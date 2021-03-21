class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], sum = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1])
                sum += nums[i];
            else
                sum = nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}