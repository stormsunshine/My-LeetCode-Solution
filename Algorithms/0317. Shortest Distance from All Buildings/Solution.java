class Solution {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int buildings = 0;
        int[][] counts = new int[rows][columns];
        int[][] distances = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    breadthFirstSearch(grid, counts, distances, i, j);
                    buildings++;
                }
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && counts[i][j] == buildings) {
                    int curDistance = distances[i][j];
                    if (curDistance == 0)
                        return -1;
                    else
                        shortestDistance = Math.min(shortestDistance, distances[i][j]);
                }
            }
        }
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    public void breadthFirstSearch(int[][] grid, int[][] counts, int[][] distances, int row, int column) {
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = grid.length, columns = grid[0].length;
        int[][] colors = new int[rows][columns];
        colors[row][column] = GRAY;
        int distance = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int curRow = cell[0], curColumn = cell[1];
                for (int[] direction : directions) {
                    int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 0 && colors[newRow][newColumn] == WHITE) {
                        colors[newRow][newColumn] = GRAY;
                        counts[newRow][newColumn]++;
                        distances[newRow][newColumn] += distance;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
                colors[curRow][curColumn] = BLACK;
            }
        }
    }
}