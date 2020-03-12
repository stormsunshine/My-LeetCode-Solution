class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        final int BORDER = 3;
        int componentColor = grid[r0][c0];
        int rows = grid.length, columns = grid[0].length;
        int[][] states = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != componentColor)
                    states[i][j] = BLOCK;
            }
        }
        states[r0][c0] = GRAY;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int count = 0;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (states[newRow][newColumn] != BLOCK)
                        count++;
                    if (states[newRow][newColumn] == WHITE) {
                        states[newRow][newColumn] = GRAY;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            if (count == 4)
                states[row][column] = BLACK;
            else
                states[row][column] = BORDER;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (states[i][j] == BORDER)
                    grid[i][j] = color;
            }
        }
        return grid;
    }
}