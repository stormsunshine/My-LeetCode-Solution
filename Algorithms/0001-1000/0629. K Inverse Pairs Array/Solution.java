class Solution {
    public int kInversePairs(int n, int k) {
        final int MODULO = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int sum = (dp[i - 1][j] + dp[i][j - 1]) % MODULO;
                dp[i][j] = (sum - ((j - i < 0) ? 0 : dp[i - 1][j - i]) + MODULO) % MODULO;
            }
        }
        return dp[n][k];
    }
}