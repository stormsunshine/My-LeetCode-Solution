class Solution {
    public int minFallingPathSum(int[][] A) {
        int side = A.length;
        int[][] dp = new int[side][side];
        for (int i = 0; i < side; i++)
            dp[0][i] = A[0][i];
        for (int i = 1; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (j == 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                else if (j == side - 1)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i][j];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < side; i++)
            minSum = Math.min(minSum, dp[side - 1][i]);
        return minSum;
    }
}