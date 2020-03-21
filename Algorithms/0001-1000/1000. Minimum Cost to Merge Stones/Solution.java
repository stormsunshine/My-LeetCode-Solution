class Solution {
    public int mergeStones(int[] stones, int K) {
        int length = stones.length;
        if (length == 1)
            return 0;
        if ((length - 1) % (K - 1) != 0)
            return -1;
        int[] prefixSum = new int[length];
        prefixSum[0] = stones[0];
        for (int i = 1; i < length; i++)
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        int[][][] dp = new int[length][length][K];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < K; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < length; i++)
            dp[i][i][0] = 0;
        for (int curLength = 2; curLength <= length; curLength++) {
            int maxStart = length - curLength;
            for (int i = 0; i <= maxStart; i++) {
                int end = i + curLength - 1;
                for (int j = 1; j < K; j++) {
                    for (int k = i; k < end; k += K - 1) {
                        dp[i][end][j] = Math.min(dp[i][end][j], dp[i][k][0] + dp[k + 1][end][j - 1]);
                        dp[i][end][0] = sum(prefixSum, i, end) + dp[i][end][j];
                    }
                }
            }
        }
        return dp[0][length - 1][0];
    }

    public int sum(int[] prefixSum, int start, int end) {
        if (start == 0)
            return prefixSum[end];
        else
            return prefixSum[end] - prefixSum[start - 1];
    }
}