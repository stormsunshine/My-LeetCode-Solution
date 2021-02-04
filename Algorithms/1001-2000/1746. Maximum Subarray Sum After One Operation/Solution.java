class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][3];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        dp[0][2] = Integer.MIN_VALUE;
        int max = dp[0][1];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], 0) + nums[i] * nums[i];
            dp[i][2] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), 0) + nums[i];
            int curMax = Math.max(dp[i][1], dp[i][2]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}