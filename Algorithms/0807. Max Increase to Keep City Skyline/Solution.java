class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, columns = grid[0].length;
        int[] skylineRows = new int[rows];
        int[] skylineColumns = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int height = grid[i][j];
                skylineRows[i] = Math.max(skylineRows[i], height);
                skylineColumns[j] = Math.max(skylineColumns[j], height);
            }
        }
        int increase = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int height = grid[i][j];
                int maxHeight = Math.min(skylineRows[i], skylineColumns[j]);
                increase += maxHeight - height;
            }
        }
        return increase;
    }
}