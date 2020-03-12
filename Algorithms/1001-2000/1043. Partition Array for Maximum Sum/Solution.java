class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;
        int length = A.length;
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int max = 0;
            int leftBound = Math.max(i - K, 0);
            for (int j = i - 1; j >= leftBound; j--) {
                max = Math.max(max, A[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            }
        }
        return dp[length];
    }
}