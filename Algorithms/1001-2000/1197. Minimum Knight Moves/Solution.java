class Solution {
    public int minKnightMoves(int x, int y) {
        final int COORDINATE = 400;
        x += COORDINATE;
        y += COORDINATE;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int length = COORDINATE * 2;
        int[][] colors = new int[length][length];
        int[][] distances = new int[length][length];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                distances[i][j] = Integer.MAX_VALUE;
        }
        colors[COORDINATE][COORDINATE] = GRAY;
        distances[COORDINATE][COORDINATE] = 0;
        queue.offer(new int[]{COORDINATE, COORDINATE});
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        while (!queue.isEmpty()) {
            int[] square = queue.poll();
            int row = square[0], column = square[1];
            int distance = distances[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < length && newColumn >= 0 && newColumn < length && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    distances[newRow][newColumn] = distance + 1;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            colors[row][column] = BLACK;
            if (colors[x][y] != WHITE)
                return distances[x][y];
        }
        return -1;
    }
}