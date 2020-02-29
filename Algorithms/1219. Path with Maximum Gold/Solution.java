class Solution {
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0)
                    backtrack(grid, i, j, 0, visited);
            }
        }
        return max;
    }

    public void backtrack(int[][] grid, int row, int column, int amount, boolean[][] visited) {
        int rows = grid.length, columns = grid[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] == 0 || visited[row][column])
            max = Math.max(max, amount);
        else {
            amount += grid[row][column];
            visited[row][column] = true;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] direction : directions)
                backtrack(grid, row + direction[0], column + direction[1], amount, visited);
            amount -= grid[row][column];
            visited[row][column] = false;
        }
    }
}