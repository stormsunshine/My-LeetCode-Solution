class Solution {
    public long maxAlternatingSum(int[] nums) {
        int length = nums.length;
        long[][] dp = new long[length][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][1], 0) + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][0] - nums[i], 0), dp[i - 1][1]);
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}