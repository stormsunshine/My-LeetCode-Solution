class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int rows = grid.length, columns = grid[0].length;
        k = Math.max(0, Math.min(k, rows + columns - 3));
        int[][][] distances = new int[rows][columns][k + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int e = 0; e <= k; e++)
                    distances[i][j][e] = Integer.MAX_VALUE;
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        distances[0][0][k] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0, k});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1], remainEliminations = cell[2];
            int distance = distances[row][column][remainEliminations];
            if (row == rows - 1 && column == columns - 1)
                return distance;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    int newRemainEliminations = remainEliminations - grid[newRow][newColumn];
                    if (newRemainEliminations >= 0 && distances[newRow][newColumn][newRemainEliminations] == Integer.MAX_VALUE) {
                        distances[newRow][newColumn][newRemainEliminations] = distance + 1;
                        queue.offer(new int[]{newRow, newColumn, newRemainEliminations});
                    }
                }
            }
        }
        return -1;
    }
}