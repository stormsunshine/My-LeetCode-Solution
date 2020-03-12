class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, columns = grid[0].length;
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int[][] colors = new int[rows][columns];
        int[][] distances = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = grid[i][j];
                if (value == 2) {
                    distances[i][j] = 0;
                    colors[i][j] = GRAY;
                    queue.offer(new int[]{i, j});
                } else if (value == 1) {
                    distances[i][j] = Integer.MAX_VALUE;
                    colors[i][j] = WHITE;
                } else {
                    distances[i][j] = -1;
                    colors[i][j] = BLOCK;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int distance = distances[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (colors[newRow][newColumn] == WHITE) {
                        distances[newRow][newColumn] = distance + 1;
                        colors[newRow][newColumn] = GRAY;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            colors[row][column] = BLACK;
        }
        int time = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                time = Math.max(time, distances[i][j]);
                if (time == Integer.MAX_VALUE)
                    return -1;
            }
        }
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}