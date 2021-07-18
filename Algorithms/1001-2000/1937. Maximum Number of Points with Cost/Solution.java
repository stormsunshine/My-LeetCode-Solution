class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = points[0][j];
        for (int i = 1; i < m; i++) {
            long[] prevRowLeft = new long[n];
            System.arraycopy(dp[i - 1], 0, prevRowLeft, 0, n);
            for (int j = n - 2; j >= 0; j--)
                prevRowLeft[j] -= n - 1 - j;
            long[] prevRowRight = new long[n];
            System.arraycopy(dp[i - 1], 0, prevRowRight, 0, n);
            for (int j = 1; j < n; j++)
                prevRowRight[j] -= j;
            long[] leftMax = new long[n];
            leftMax[0] = prevRowLeft[0];
            for (int j = 1; j < n; j++)
                leftMax[j] = Math.max(leftMax[j - 1], prevRowLeft[j]);
            long[] rightMax = new long[n];
            rightMax[n - 1] = prevRowRight[n - 1];
            for (int j = n - 2; j >= 0; j--)
                rightMax[j] = Math.max(rightMax[j + 1], prevRowRight[j]);
            for (int j = 0; j < n; j++) {
                long curLeftMax = leftMax[j] + n - 1 - j;
                long curRightMax = rightMax[j] + j;
                dp[i][j] = Math.max(curLeftMax, curRightMax) + points[i][j];
            }
        }
        long maxScore = 0;
        for (int j = 0; j < n; j++)
            maxScore = Math.max(maxScore, dp[m - 1][j]);
        return maxScore;
    }
}