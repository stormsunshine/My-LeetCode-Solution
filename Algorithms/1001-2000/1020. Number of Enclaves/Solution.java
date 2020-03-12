class Solution {
    public int numEnclaves(int[][] A) {
        int rows = A.length, columns = A[0].length;
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                grid[i][j] = A[i][j];
        }
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1)
                breadthFirstSearch(grid, i, 0);
            if (grid[i][columns - 1] == 1)
                breadthFirstSearch(grid, i, columns - 1);
        }
        for (int i = 0; i < columns; i++) {
            if (grid[0][i] == 1)
                breadthFirstSearch(grid, 0, i);
            if (grid[rows - 1][i] == 1)
                breadthFirstSearch(grid, rows - 1, i);
        }
        int enclaves = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1)
                    enclaves++;
            }
        }
        return enclaves;
    }

    public void breadthFirstSearch(int[][] grid, int row, int column) {
        if (grid[row][column] == 0)
            return;
        int rows = grid.length, columns = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        grid[row][column] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1) {
                    grid[newRow][newColumn] = 0;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
    }
}