class Solution {
    public int rearrangeSticks(int n, int k) {
        final int MODULO = 1000000007;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[i][i] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = (int) ((long) dp[i - 1][1] * (i - 1) % MODULO);
            for (int j = 2; j <= i; j++)
                dp[i][j] = (int) ((dp[i - 1][j - 1] + (long) dp[i - 1][j] * (i - 1)) % MODULO);
        }
        return dp[n][k];
    }
}