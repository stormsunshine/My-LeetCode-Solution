class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(entrance);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newColumn = column + direction[1];
                    if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && !visited[newRow][newColumn] && maze[newRow][newColumn] == '.') {
                        if (newRow == 0 || newRow == m - 1 || newColumn == 0 || newColumn == n - 1)
                            return steps;
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        return -1;
    }
}