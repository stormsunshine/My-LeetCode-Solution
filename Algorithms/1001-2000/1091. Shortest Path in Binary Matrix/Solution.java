class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int side = grid.length;
        if (grid[0][0] == 1 || grid[side - 1][side - 1] == 1)
            return -1;
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int[][] colors = new int[side][side];
        int[][] distances = new int[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (grid[i][j] == 0) {
                    colors[i][j] = WHITE;
                    distances[i][j] = Integer.MAX_VALUE;
                } else {
                    colors[i][j] = BLOCK;
                    distances[i][j] = -1;
                }
            }
        }
        colors[0][0] = GRAY;
        distances[0][0] = 1;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int distance = distances[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < side && newColumn >= 0 && newColumn < side && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    distances[newRow][newColumn] = distance + 1;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            colors[row][column] = BLACK;
        }
        return distances[side - 1][side - 1] == Integer.MAX_VALUE ? -1 : distances[side - 1][side - 1];
    }
}