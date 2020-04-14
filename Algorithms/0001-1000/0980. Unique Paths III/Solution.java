class Solution {
    final int BLOCK = -1;
    final int UNVISITED = 0;
    final int VISITED = 1;
    int paths = 0;

    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startColumn = 0, endRow = 0, endColumn = 0;
        int rows = grid.length, columns = grid[0].length;
        int[][] states = new int[rows][columns];
        int squares = rows * columns;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == -1) {
                    squares--;
                    states[i][j] = BLOCK;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startColumn = j;
                } else if (grid[i][j] == 2) {
                    endRow = i;
                    endColumn = j;
                }
            }
        }
        backtrack(grid, states, squares, startRow, startColumn, endRow, endColumn);
        return paths;
    }

    public void backtrack(int[][] grid, int[][] states, int squares, int startRow, int startColumn, int endRow, int endColumn) {
        if (startRow == endRow && startColumn == endColumn) {
            if (squares == 1)
                paths++;
        } else {
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int rows = grid.length, columns = grid[0].length;
            squares--;
            states[startRow][startColumn] = VISITED;
            for (int[] direction : directions) {
                int row = startRow + direction[0], column = startColumn + direction[1];
                if (row >= 0 && row < rows && column >= 0 && column < columns && states[row][column] == UNVISITED)
                    backtrack(grid, states, squares, row, column, endRow, endColumn);
            }
            squares++;
            states[startRow][startColumn] = UNVISITED;
        }
    }
}