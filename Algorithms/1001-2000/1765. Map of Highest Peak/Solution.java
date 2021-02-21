class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length, columns = isWater[0].length;
        int[][] heights = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else
                    heights[i][j] = -1;
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int height = heights[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && heights[newRow][newColumn] == -1) {
                    heights[newRow][newColumn] = height + 1;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return heights;
    }
}