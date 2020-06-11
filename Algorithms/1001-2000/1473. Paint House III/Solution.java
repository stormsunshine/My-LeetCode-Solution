class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int INFINITY = 1000000000;
        int[][][] dp = new int[m + 1][target + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = INFINITY;
            }
        }
        if (houses[0] > 0)
            dp[0][1][houses[0]] = 0;
        else {
            for (int i = 1; i <= n; i++)
                dp[0][1][i] = cost[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if (houses[i] > 0) {
                    int temp = houses[i];
                    for (int k = 1; k <= n; k++) {
                        if (temp == k)
                            dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j][k]);
                        else
                            dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j - 1][k]);
                    }
                } else {
                    for (int k = 1; k <= n; k++) {
                        for (int s = 1; s <= n; s++) {
                            if (k == s)
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][s] + cost[i][k - 1]);
                            else
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][s] + cost[i][k - 1]);
                        }
                    }
                }
            }
        }
        int minCost = INFINITY;
        for (int i = 1; i <= n; i++)
            minCost = Math.min(minCost, dp[m - 1][target][i]);
        return minCost == INFINITY ? -1 : minCost;
    }
}