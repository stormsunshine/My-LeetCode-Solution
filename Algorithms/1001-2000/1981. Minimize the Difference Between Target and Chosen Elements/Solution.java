class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int rows = mat.length, columns = mat[0].length;
        boolean[][] dp = new boolean[rows + 1][4901];
        dp[0][0] = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= 4900; j++) {
                if (dp[i][j]) {
                    for (int k = 0; k < columns; k++)
                        dp[i + 1][j + mat[i][k]] = true;
                }
            }
        }
        int minDifference = Integer.MAX_VALUE;
        for (int j = 0; j <= 4900; j++) {
            if (dp[rows][j]) {
                int difference = Math.abs(j - target);
                minDifference = Math.min(minDifference, difference);
            }
        }
        return minDifference;
    }
}