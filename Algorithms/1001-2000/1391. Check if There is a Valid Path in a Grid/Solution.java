class Solution {
    public boolean hasValidPath(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == rows - 1 && cell[1] == columns - 1)
                return true;
            List<int[]> reachableCells = reachableCells(grid[cell[0]][cell[1]], grid, cell, rows, columns);
            for (int[] reachableCell : reachableCells) {
                int row = reachableCell[0], column = reachableCell[1];
                if (!visited[row][column]) {
                    visited[row][column] = true;
                    queue.offer(new int[]{row, column});
                }
            }
        }
        return false;
    }

    public List<int[]> reachableCells(int street, int[][] grid, int[] cell, int rows, int columns) {
        List<int[]> reachableCells = new ArrayList<int[]>();
        int row = cell[0], column = cell[1];
        if (street == 1) {
            int newColumn1 = column - 1, newColumn2 = column + 1;
            if (newColumn1 >= 0) {
                int newStreet = grid[row][newColumn1];
                if (newStreet == 1 || newStreet == 4 || newStreet == 6)
                    reachableCells.add(new int[]{row, newColumn1});
            }
            if (newColumn2 < columns) {
                int newStreet = grid[row][newColumn2];
                if (newStreet == 1 || newStreet == 3 || newStreet == 5)
                    reachableCells.add(new int[]{row, newColumn2});
            }
        } else if (street == 2) {
            int newRow1 = row - 1, newRow2 = row + 1;
            if (newRow1 >= 0) {
                int newStreet = grid[newRow1][column];
                if (newStreet == 2 || newStreet == 3 || newStreet == 4)
                    reachableCells.add(new int[]{newRow1, column});
            }
            if (newRow2 < rows) {
                int newStreet = grid[newRow2][column];
                if (newStreet == 2 || newStreet == 5 || newStreet == 6)
                    reachableCells.add(new int[]{newRow2, column});
            }
        } else if (street == 3) {
            int newRow = row + 1, newColumn = column - 1;
            if (newRow < rows) {
                int newStreet = grid[newRow][column];
                if (newStreet == 2 || newStreet == 5 || newStreet == 6)
                    reachableCells.add(new int[]{newRow, column});
            }
            if (newColumn >= 0) {
                int newStreet = grid[row][newColumn];
                if (newStreet == 1 || newStreet == 4 || newStreet == 6)
                    reachableCells.add(new int[]{row, newColumn});
            }
        } else if (street == 4) {
            int newRow = row + 1, newColumn = column + 1;
            if (newRow < rows) {
                int newStreet = grid[newRow][column];
                if (newStreet == 2 || newStreet == 5 || newStreet == 6)
                    reachableCells.add(new int[]{newRow, column});
            }
            if (newColumn < columns) {
                int newStreet = grid[row][newColumn];
                if (newStreet == 1 || newStreet == 3 || newStreet == 5)
                    reachableCells.add(new int[]{row, newColumn});
            }
        } else if (street == 5) {
            int newRow = row - 1, newColumn = column - 1;
            if (newRow >= 0) {
                int newStreet = grid[newRow][column];
                if (newStreet == 2 || newStreet == 3 || newStreet == 4)
                    reachableCells.add(new int[]{newRow, column});
            }
            if (newColumn >= 0) {
                int newStreet = grid[row][newColumn];
                if (newStreet == 1 || newStreet == 4 || newStreet == 6)
                    reachableCells.add(new int[]{row, newColumn});
            }
        } else if (street == 6) {
            int newRow = row - 1, newColumn = column + 1;
            if (newRow >= 0) {
                int newStreet = grid[newRow][column];
                if (newStreet == 2 || newStreet == 3 || newStreet == 4)
                    reachableCells.add(new int[]{newRow, column});
            }
            if (newColumn < columns) {
                int newStreet = grid[row][newColumn];
                if (newStreet == 1 || newStreet == 3 || newStreet == 5)
                    reachableCells.add(new int[]{row, newColumn});
            }
        }
        return reachableCells;
    }
}