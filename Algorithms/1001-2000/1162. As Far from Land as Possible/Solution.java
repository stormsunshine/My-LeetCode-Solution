class Solution {
    public int maxDistance(int[][] grid) {
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int sideLength = grid.length;
        int[][] colors = new int[sideLength][sideLength];
        int[][] distances = new int[sideLength][sideLength];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (grid[i][j] == 1) {
                    colors[i][j] = GRAY;
                    distances[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    colors[i][j] = WHITE;
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if (queue.isEmpty() || queue.size() == sideLength * sideLength)
            return -1;
        int maxDistance = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int distance = distances[row][column];
            maxDistance = Math.max(maxDistance, distance);
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < sideLength && newColumn >= 0 && newColumn < sideLength && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    distances[newRow][newColumn] = Math.min(distances[newRow][newColumn], distance + 1);
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            colors[row][column] = BLACK;
        }
        return maxDistance;
    }
}