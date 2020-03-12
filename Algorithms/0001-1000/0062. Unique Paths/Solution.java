class Solution {
    public int uniquePaths(int m, int n) {
        int[][] counts = new int[m][n];
        for (int i = 0; i < m; i++)
            counts[i][0] = 1;
        for (int j = 1; j < n; j++)
            counts[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                counts[i][j] = counts[i - 1][j] + counts[i][j - 1];
        }
        return counts[m - 1][n - 1];
    }
}