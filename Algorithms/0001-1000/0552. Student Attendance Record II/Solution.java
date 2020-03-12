class Solution {
    public int checkRecord(int n) {
        final int MODULO = 1000000007;
        long[][] dp = new long[n][7];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][5] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % MODULO;
            dp[i][1] = dp[i - 1][5];
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][6]) % MODULO;
            dp[i][3] = dp[i - 1][1];
            dp[i][4] = dp[i - 1][2];
            dp[i][5] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % MODULO;
            dp[i][6] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6]) % MODULO;
        }
        long sum = 0;
        for (int i = 0; i < 7; i++)
            sum = (sum + dp[n - 1][i]) % MODULO;
        int res = (int) sum;
        return res;
    }
}