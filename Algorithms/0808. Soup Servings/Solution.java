class Solution {
    public double soupServings(int N) {
        int units = (int) Math.ceil(N / 25.0);
        if (units >= 500)
            return 1;
        double[][] dp = new double[units + 1][units + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= units; i++) {
            dp[0][i] = 1;
            dp[i][0] = 0;
        }
        for (int i = 1; i <= units; i++) {
            for (int j = 1; j <= units; j++) {
                int i1 = Math.max(i - 4, 0), j1 = j;
                int i2 = Math.max(i - 3, 0), j2 = Math.max(j - 1, 0);
                int i3 = Math.max(i - 2, 0), j3 = Math.max(j - 2, 0);
                int i4 = Math.max(i - 1, 0), j4 = Math.max(j - 3, 0);
                dp[i][j] = (dp[i1][j1] + dp[i2][j2] + dp[i3][j3] + dp[i4][j4]) / 4;
            }
        }
        return dp[units][units];
    }
}