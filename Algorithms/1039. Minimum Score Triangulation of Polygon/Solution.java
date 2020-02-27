class Solution {
    public int minScoreTriangulation(int[] A) {
        int length = A.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                dp[i][j] = Integer.MAX_VALUE;
            dp[i][(i + 1) % length] = 0;
        }
        for (int curLength = 2; curLength < length; curLength++) {
            for (int i = 0; i < length; i++) {
                int j = (i + curLength) % length;
                for (int k = (i + 1) % length; k != j; k = (k + 1) % length)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
            }
        }
        return dp[0][length - 1];
    }
}