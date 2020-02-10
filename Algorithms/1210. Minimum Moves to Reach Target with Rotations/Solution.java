class Solution {
    public int minimumMoves(int[][] grid) {
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = grid.length, columns = grid[0].length;
        if (grid[rows - 1][columns - 1] == 1 || grid[rows - 1][columns - 2] == -1)
            return -1;
        int[][][] colors = new int[rows][columns][2];
        int[][][] distances = new int[rows][columns][2];
        for (int i = 0; i < rows; i++)
            colors[i][columns - 1][0] = BLOCK;
        for (int i = 0; i < columns; i++)
            colors[rows - 1][i][1] = BLOCK;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    colors[i][j][0] = BLOCK;
                    colors[i][j][1] = BLOCK;
                    if (i > 0)
                        colors[i - 1][j][1] = BLOCK;
                    if (j > 0)
                        colors[i][j - 1][0] = BLOCK;
                }
                distances[i][j][0] = Integer.MAX_VALUE;
                distances[i][j][1] = Integer.MAX_VALUE;
            }
        }
        colors[0][0][0] = GRAY;
        distances[0][0][0] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] status = queue.poll();
            int row = status[0], column = status[1], direction = status[2];
            int distance = distances[row][column][direction];
            int newRow = row + 1, newColumn = column + 1, newDirection = 1 - direction;
            int newDistance = distance + 1;
            if (newRow < rows && colors[newRow][column][direction] == WHITE) {
                colors[newRow][column][direction] = GRAY;
                distances[newRow][column][direction] = newDistance;
                queue.offer(new int[]{newRow, column, direction});
            }
            if (newColumn < columns && colors[row][newColumn][direction] == WHITE) {
                colors[row][newColumn][direction] = GRAY;
                distances[row][newColumn][direction] = newDistance;
                queue.offer(new int[]{row, newColumn, direction});
            }
            if (colors[row][column][newDirection] == WHITE) {
                if (row < rows - 1 && column < columns - 1 && grid[row + 1][column + 1] == 0) {
                    colors[row][column][newDirection] = GRAY;
                    distances[row][column][newDirection] = newDistance;
                    queue.offer(new int[]{row, column, newDirection});
                }
            }
            colors[row][column][direction] = BLACK;
        }
        int totalMoves = distances[rows - 1][columns - 2][0];
        return totalMoves == Integer.MAX_VALUE ? -1 : totalMoves;
    }
}