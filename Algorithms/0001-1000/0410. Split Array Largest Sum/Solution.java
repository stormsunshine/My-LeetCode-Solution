class Solution {
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int[][] dp = new int[length + 1][m + 1];
        int[] subSum = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < length; i++)
            subSum[i + 1] = subSum[i] + nums[i];
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], subSum[i] - subSum[k]));
            }
        }
        return dp[length][m];
    }
}