class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        int[][] counts = new int[rows][columns];
        for (int i = 0; i < rows && obstacleGrid[i][0] == 0; i++)
            counts[i][0] = 1;
        for (int j = 0; j < columns && obstacleGrid[0][j] == 0; j++)
            counts[0][j] = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] != 1)
                    counts[i][j] = counts[i - 1][j] + counts[i][j - 1];
            }
        }
        return counts[rows - 1][columns - 1];
    }
}