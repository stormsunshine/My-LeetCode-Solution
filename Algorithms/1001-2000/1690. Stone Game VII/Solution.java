class Solution {
    public int stoneGameVII(int[] stones) {
        int length = stones.length;
        int[] prefixSums = new int[length];
        prefixSums[0] = stones[0];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + stones[i];
        int[][] dp = new int[length][length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++)
                dp[i][j] = Math.max(getRangeSum(prefixSums, i + 1, j) - dp[i + 1][j], getRangeSum(prefixSums, i, j - 1) - dp[i][j - 1]);
        }
        return dp[0][length - 1];
    }

    public int getRangeSum(int[] prefixSums, int start, int end) {
        return start == 0 ? prefixSums[end] : prefixSums[end] - prefixSums[start - 1];
    }
}