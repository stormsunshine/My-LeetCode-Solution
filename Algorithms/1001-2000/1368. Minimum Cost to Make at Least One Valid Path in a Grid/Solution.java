class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        if (rows == 1 && columns == 1)
            return 0;
        int cost = 0;
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        List<int[]> levelList = new ArrayList<int[]>();
        levelList.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            int directionIndex = grid[row][column] - 1;
            if (directionIndex >= 0) {
                int[] direction = directions[directionIndex];
                int newRow = row + direction[0], newColumn = column + direction[1];
                while (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    levelList.add(new int[]{newRow, newColumn});
                    int nextDirectionIndex = grid[newRow][newColumn] - 1;
                    if (nextDirectionIndex < 0)
                        break;
                    newRow += directions[nextDirectionIndex][0];
                    newColumn += directions[nextDirectionIndex][1];
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int newRow = row + directions[i][0], newColumn = column + directions[i][1];
                    while (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        levelList.add(new int[]{newRow, newColumn});
                        int nextDirectionIndex = grid[newRow][newColumn] - 1;
                        if (nextDirectionIndex < 0)
                            break;
                        newRow += directions[nextDirectionIndex][0];
                        newColumn += directions[nextDirectionIndex][1];
                    }
                }
            }
            if (queue.isEmpty() && !levelList.isEmpty()) {
                for (int[] levelCell : levelList) {
                    int curRow = levelCell[0], curColumn = levelCell[1];
                    if (curRow == rows - 1 && curColumn == columns - 1)
                        return cost;
                    queue.offer(levelCell);
                    grid[curRow][curColumn] = -1;
                }
                cost++;
                levelList.clear();
            }
        }
		return cost;
    }
}