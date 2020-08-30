class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minDays(int[][] grid) {
        int lands = 0;
        int count = 0;
        int minConnection = 4;
        int rows = grid.length, columns = grid[0].length;
        int[][] connections = new int[rows][columns];
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    lands++;
                    int curConnection = getConnection(grid, i, j);
                    connections[i][j] = curConnection;
                    minConnection = Math.min(minConnection, curConnection);
                    if (!visited[i][j]) {
                        count++;
                        depthFirstSearch(grid, visited, i, j);
                    }
                }
            }
        }
        if (count > 1)
            return 0;
        else if (minConnection == 1)
            return lands == 2 ? 2 : 1;
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == 1 && canDisconnect(grid, i, j))
                        return 1;
                }
            }
            return 2;
        }
    }

    public int getConnection(int[][] grid, int row, int column) {
        int connection = 0;
        int rows = grid.length, columns = grid[0].length;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1)
                connection++;
        }
        return connection;
    }

    public boolean canDisconnect(int[][] grid, int row, int column) {
        grid[row][column] = 0;
        int count = 0;
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (count == 0) {
                        count++;
                        depthFirstSearch(grid, visited, i, j);
                    } else {
                        grid[row][column] = 1;
                        return true;
                    }
                }
            }
        }
        grid[row][column] = 1;
        return false;
    }

    public void depthFirstSearch(int[][] grid, boolean[][] visited, int row, int column) {
        visited[row][column] = true;
        int rows = grid.length, columns = grid[0].length;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1 && !visited[newRow][newColumn])
                depthFirstSearch(grid, visited, newRow, newColumn);
        }
    }
}