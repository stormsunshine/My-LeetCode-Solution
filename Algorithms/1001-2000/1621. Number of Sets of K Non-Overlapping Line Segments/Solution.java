class Solution {
    public int numberOfSets(int n, int k) {
        final int MODULO = 1000000007;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MODULO;
                dp[i][j][1] = dp[i - 1][j][1];
                if (j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][0]) % MODULO;
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % MODULO;
                }
            }
        }
        return (dp[n - 1][k][0] + dp[n - 1][k][1]) % MODULO;
    }
}