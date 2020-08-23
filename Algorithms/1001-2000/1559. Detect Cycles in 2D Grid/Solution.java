class Solution {
    int rows;
    int columns;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean flag = false;

    public boolean containsCycle(char[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        if (rows < 2 || columns < 2)
            return false;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows && !flag; i++) {
            for (int j = 0; j < columns && !flag; j++) {
                if (!visited[i][j])
                    depthFirstSearch(grid, visited, i, j);
            }
        }
        return flag;
    }

    public void depthFirstSearch(char[][] grid, boolean[][] visited, int row, int column) {
        visited[row][column] = true;
        char c = grid[row][column];
        int value = row * columns + column;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == c) {
                int key = newRow * columns + newColumn;
                if (!visited[newRow][newColumn]) {
                    map.put(key, value);
                    depthFirstSearch(grid, visited, newRow, newColumn);
                } else if (map.getOrDefault(value, -1) != key)
                    flag = true;
            }
        }
    }
}