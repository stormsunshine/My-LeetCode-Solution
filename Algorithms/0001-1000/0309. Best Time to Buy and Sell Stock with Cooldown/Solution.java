public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = dp[i - 1][1];
        }
        int maxProfit = 0;
        for (int i = 0; i < 3; i++)
            maxProfit = Math.max(maxProfit, dp[length - 1][i]);
        return maxProfit;
    }
}