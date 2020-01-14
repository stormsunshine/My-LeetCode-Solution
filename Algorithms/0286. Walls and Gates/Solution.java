class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int rows = rooms.length, columns = rooms[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(new int[]{i, j});
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int distance = rooms[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && rooms[newRow][newColumn] == Integer.MAX_VALUE) {
                    rooms[newRow][newColumn] = distance + 1;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
    }
}