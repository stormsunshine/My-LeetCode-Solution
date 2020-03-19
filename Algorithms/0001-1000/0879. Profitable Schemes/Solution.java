class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        final int MODULO = 1000000007;
        int length = group.length;
        int[][][] dp = new int[length + 1][P + 1][G + 1];
        dp[0][0][G] = 1;
        for (int i = 1; i <= length; i++) {
            int curProfit = profit[i - 1];
            int curGroup = group[i - 1];
            for (int j = 0; j <= P; j++) {
                int totalProfit = Math.min(j + curProfit, P);
                for (int k = 0; k <= G; k++) {
                    if (k >= curGroup)
                        dp[i][totalProfit][k - curGroup] = (dp[i][totalProfit][k - curGroup] + dp[i - 1][j][k]) % MODULO;
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k]) % MODULO;
                }
            }
        }
        int schemes = 0;
        for (int i = 0; i <= G; i++)
            schemes = (schemes + dp[length][P][i]) % MODULO;
        return schemes;
    }
}