class Solution {
    public int waysToDistribute(int n, int k) {
        final int MODULO = 1000000007;
        long[][] dp = new long[k][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++)
                dp[i][j] = (dp[i][j - 1] * (i + 1) + dp[i - 1][j - 1]) % MODULO;
        }
        return (int) dp[k - 1][n - 1];
    }
}