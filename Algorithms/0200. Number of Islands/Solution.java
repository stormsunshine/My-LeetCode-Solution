class Solution {
    final int BLOCK = -1;
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, columns = grid[0].length;
        int[][] colors = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '0')
                    colors[i][j] = BLOCK;
            }
        }
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (colors[i][j] == WHITE) {
                    breadthFirstSearch(grid, colors, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void breadthFirstSearch(char[][] grid, int[][] colors, int row, int column) {
        int rows = grid.length, columns = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        colors[row][column] = GRAY;
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] square = queue.poll();
            int curRow = square[0], curColumn = square[1];
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