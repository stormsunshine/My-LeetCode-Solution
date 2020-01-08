class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0)
            return 0;
        int length = costs.length, colors = costs[0].length;
        int[][] dp = new int[length][colors];
        for (int i = 0; i < colors; i++)
            dp[0][i] = costs[0][i];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < colors; j++) {
                int curCost = costs[i][j];
                int prevMinSum = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (j == k)
                        continue;
                    prevMinSum = Math.min(prevMinSum, dp[i - 1][k]);
                }
                dp[i][j] = prevMinSum + curCost;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < colors; i++)
            minCost = Math.min(minCost, dp[length - 1][i]);
        return minCost;
    }
}