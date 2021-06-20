class Solution {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid1.length, n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    boolean isSubisland = breadthFirstSearch(grid1, grid2, visited, m, n, i, j);
                    if (isSubisland)
                        subIslands++;
                }
            }
        }
        return subIslands;
    }

    public boolean breadthFirstSearch(int[][] grid1, int[][] grid2, boolean[][] visited, int m, int n, int startRow, int startColumn) {
        boolean isSubisland = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            if (grid1[row][column] == 0)
                isSubisland = false;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && grid2[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return isSubisland;
    }
}