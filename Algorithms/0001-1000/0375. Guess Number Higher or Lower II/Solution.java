class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int length = 2; length <= n; length++) {
            for (int start = 1; start <= n - length + 1; start++) {
                int minCost = Integer.MAX_VALUE;
                for (int mid = start; mid < start + length - 1; mid++) {
                    int cost = mid + Math.max(dp[start][mid - 1], dp[mid + 1][start + length - 1]);
                    minCost = Math.min(minCost, cost);
                }
                dp[start][start + length - 1] = minCost;
            }
        }
        return dp[1][n];
    }
}