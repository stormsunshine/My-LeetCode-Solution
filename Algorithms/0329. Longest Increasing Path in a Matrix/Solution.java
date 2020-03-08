class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] outdegrees = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int[] direction : directions) {
                    int newRow = i + direction[0], newColumn = j + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j])
                        outdegrees[i][j]++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (outdegrees[i][j] == 0)
                    queue.offer(new int[]{i, j});
            }
        }
        int maxLength = 0;
        while (!queue.isEmpty()) {
            maxLength++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newColumn = column + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                        outdegrees[newRow][newColumn]--;
                        if (outdegrees[newRow][newColumn] == 0)
                            queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        return maxLength;
    }
}