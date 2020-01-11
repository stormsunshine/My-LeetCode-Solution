class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            if (prices[i] - prices[i - 1] > 0)
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}