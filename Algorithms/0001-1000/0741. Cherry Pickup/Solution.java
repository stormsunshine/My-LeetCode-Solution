class Solution {
    public int cherryPickup(int[][] grid) {
        int length = grid.length;
        int[][][] dp = new int[length][length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++)
                    dp[i][j][k] = -1;
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int kMax = Math.min(i + j, length - 1);
                for (int k = 0; k <= kMax; k++) {
                    int m = i + j - k;
                    if (m < 0 || m >= length)
                        continue;
                    if (grid[i][j] == -1 || grid[k][m] == -1)
                        continue;
                    int num1 = i == 0 || k == 0 ? -1 : dp[i - 1][j][k - 1];
                    int num2 = i == 0 ? -1 : dp[i - 1][j][k];
                    int num3 = j == 0 || k == 0 ? -1 : dp[i][j - 1][k - 1];
                    int num4 = j == 0 ? -1 : dp[i][j - 1][k];
                    int currentCherries = max(num1, num2, num3, num4);
                    if (currentCherries < 0)
                        continue;
                    currentCherries += grid[i][j];
                    if (i != k || j != m)
                        currentCherries += grid[k][m];
                    dp[i][j][k] = currentCherries;
                }
            }
        }
        return Math.max(0, dp[length - 1][length - 1][length - 1]);
    }

    public int max(int num1, int num2, int num3, int num4) {
        return Math.max(Math.max(Math.max(num1, num2), num3), num4);
    }
}