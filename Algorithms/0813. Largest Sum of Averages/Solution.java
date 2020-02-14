class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int length = A.length;
        double[] prefixSums = new double[length + 1];
        for (int i = 1; i <= length; i++)
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        double[][] dp = new double[length + 1][K + 1];
        for (int i = 1; i <= length; i++) {
            dp[i][1] = prefixSums[i] / i;
            int maxGroups = Math.min(i, K);
            for (int k = 2; k <= maxGroups; k++) {
                for (int j = 1; j < i; j++)
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (prefixSums[i] - prefixSums[j]) / (i - j));
            }
        }
        return dp[length][K];
    }
}