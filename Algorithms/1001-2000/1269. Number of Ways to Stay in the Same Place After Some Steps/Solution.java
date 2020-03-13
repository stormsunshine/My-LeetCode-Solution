class Solution {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen, steps + 1);
        long[][] dp = new long[steps + 1][maxColumn];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j + 1 < maxColumn)
                    dp[i][j] += dp[i - 1][j + 1];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] %= MODULO;
            }
        }
        return (int) dp[steps][0];
    }
}