class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlandsList = new ArrayList<int[]>();
        int rows = land.length, columns = land[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] farmland = breadthFirstSearch(land, visited, i, j);
                    farmlandsList.add(farmland);
                }
            }
        }
        int size = farmlandsList.size();
        int[][] farmlands = new int[size][4];
        for (int i = 0; i < size; i++) {
            int[] farmland = farmlandsList.get(i);
            for (int j = 0; j < 4; j++)
                farmlands[i][j] = farmland[j];
        }
        return farmlands;
    }

    public int[] breadthFirstSearch(int[][] land, boolean[][] visited, int row, int column) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = land.length, columns = land[0].length;
        int[] farmland = {rows, columns, -1, -1};
        visited[row][column] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            farmland[0] = Math.min(farmland[0], curRow);
            farmland[1] = Math.min(farmland[1], curColumn);
            farmland[2] = Math.max(farmland[2], curRow);
            farmland[3] = Math.max(farmland[3], curColumn);
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && land[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return farmland;
    }
}