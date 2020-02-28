class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        final int MODULO = 1000000007;
        int[][][] dp = new int[n][6][15];
        for (int i = 0; i < 6; i++)
            dp[0][i][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == j)
                        continue;
                    for (int m = 0; m < 15; m++)
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][k][m]) % MODULO;
                }
                int max = rollMax[j];
                for (int k = 1; k < max; k++)
                    dp[i][j][k] = dp[i - 1][j][k - 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 15; j++)
                sum = (sum + dp[n - 1][i][j]) % MODULO;
        }
        return sum;
    }
}