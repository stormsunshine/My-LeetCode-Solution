class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        if (k > length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < length; i++) {
                if (prices[i] - prices[i - 1] > 0)
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        } else {
            int[][][] dp = new int[length + 1][k + 1][2];
            for (int i = 0; i < length; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Integer.MIN_VALUE;
            }
            for (int i = k; i > 0; i--) {
                dp[0][i][0] = 0;
                dp[0][i][1] = Integer.MIN_VALUE;
            }
            for (int i = 1; i <= length; i++) {
                int price = prices[i - 1];
                for (int j = 1; j <= k; j++) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + price);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - price);
                }
            }
            return dp[length][k][0];
        }
    }
}