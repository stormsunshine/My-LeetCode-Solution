class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length, columns = grid[0].length;
        int[][] tempGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                tempGrid[i][j] = grid[i][j];
        }
        for (int[] hit : hits) {
            int row = hit[0], column = hit[1];
            if (tempGrid[row][column] == 1)
                tempGrid[row][column] = -1;
        }
        for (int i = 0; i < columns; i++)
            breadthFirstSearchTop(tempGrid, 0, i);
        int hitsCount = hits.length;
        int[] falls = new int[hitsCount];
        for (int i = hitsCount - 1; i >= 0; i--) {
            int[] hit = hits[i];
            falls[i] = breadthFirstSearch(tempGrid, hit[0], hit[1]);
        }
        return falls;
    }

    public void breadthFirstSearchTop(int[][] grid, int row, int column) {
        if (grid[row][column] == 1) {
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int rows = grid.length, columns = grid[0].length;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{row, column});
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int curRow = cell[0], curColumn = cell[1];
                grid[curRow][curColumn] = 2;
                for (int[] direction : directions) {
                    int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1)
                        queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
    }

    public int breadthFirstSearch(int[][] grid, int row, int column) {
        if (grid[row][column] == 0)
            return 0;
        boolean flag = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, columns = grid[0].length;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 2) {
                flag = true;
                break;
            }
        }
        if (!flag && row > 0) {
            grid[row][column] = 1;
            return 0;
        }
        int fall = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            if (grid[curRow][curColumn] == 1)
                fall++;
            grid[curRow][curColumn] = 2;
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1)
                    queue.offer(new int[]{newRow, newColumn});
            }
        }
        return fall;
    }
}