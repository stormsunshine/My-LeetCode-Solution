class Solution {
    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        int[] finalPrices = new int[length];
        for (int i = 0; i < length; i++)
            finalPrices[i] = prices[i];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[j] <= prices[i]) {
                    finalPrices[i] -= prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }
}