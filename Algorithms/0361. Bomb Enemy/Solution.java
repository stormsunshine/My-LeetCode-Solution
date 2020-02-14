class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int max = 0;
        int rows = grid.length, columns = grid[0].length;
        int[][] counts = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'E') {
                    int curCount = getCounts(grid, counts, i, j);
                    max = Math.max(max, curCount);
                }
            }
        }
        return max;
    }

    public int getCounts(char[][] grid, int[][] counts, int row, int column) {
        int curCount = 0;
        int rows = grid.length, columns = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int curRow = row, curColumn = column;
            while (curRow >= 0 && curRow < rows && curColumn >= 0 && curColumn < columns && grid[curRow][curColumn] != 'W') {
                if (grid[curRow][curColumn] == '0') {
                    counts[curRow][curColumn]++;
                    curCount = Math.max(curCount, counts[curRow][curColumn]);
                }
                curRow += direction[0];
                curColumn += direction[1];
            }
        }
        return curCount;
    }
}