class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] distances = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    distances[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int distance = distances[row][column];
            int newDistance = distance + 1;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (distances[newRow][newColumn] > newDistance) {
                        distances[newRow][newColumn] = newDistance;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        return distances;
    }
}