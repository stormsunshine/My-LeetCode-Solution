class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        if (amount < coins[0])
            return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount)
                dp[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                int prevAmount = i - coin;
                if (prevAmount < 0)
                    break;
                if (dp[prevAmount] != Integer.MAX_VALUE) {
                    int curCoins = dp[prevAmount] + 1;
                    if (curCoins < minCoins)
                        minCoins = curCoins;
                }
            }
            dp[i] = minCoins;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}