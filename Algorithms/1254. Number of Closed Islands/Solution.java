class Solution {
    final int WATER = -1;
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, columns = grid[0].length;
        int insideRows = rows - 1, insideColumns = columns - 1;
        int[][] colors = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                colors[i][j] = grid[i][j] == 1 ? WATER : WHITE;
        }
        for (int i = 0; i < rows; i++) {
            if (colors[i][0] == WHITE)
                breadthFirstSearch(grid, colors, i, 0);
            if (colors[i][columns - 1] == WHITE)
                breadthFirstSearch(grid, colors, i, columns - 1);
        }
        for (int i = 1; i < insideColumns; i++) {
            if (colors[0][i] == WHITE)
                breadthFirstSearch(grid, colors, 0, i);
            if (colors[rows - 1][i] == WHITE)
                breadthFirstSearch(grid, colors, rows - 1, i);
        }
        int islandCount = 0;
        for (int i = 1; i < insideRows; i++) {
            for (int j = 1; j < insideColumns; j++) {
                if (colors[i][j] == WHITE) {
                    breadthFirstSearch(grid, colors, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void breadthFirstSearch(int[][] grid, int[][] colors, int row, int column) {
        int rows = grid.length, columns = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        colors[row][column] = GRAY;
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            colors[curRow][curColumn] = BLACK;
        }
    }
}