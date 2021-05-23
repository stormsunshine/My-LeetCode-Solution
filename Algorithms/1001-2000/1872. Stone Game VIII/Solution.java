class Solution {
    public int stoneGameVIII(int[] stones) {
        int length = stones.length;
        if (length == 2)
            return stones[0] + stones[1];
        int[] prefixSums = new int[length];
        prefixSums[0] = stones[0];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + stones[i];
        int[] dp = new int[length];
        dp[length - 1] = prefixSums[length - 1];
        int maxDiff = dp[length - 1];
        for (int i = length - 2; i > 0; i--) {
            dp[i] = prefixSums[i] - maxDiff;
            maxDiff = Math.max(maxDiff, dp[i]);
        }
        return maxDiff;
    }
}