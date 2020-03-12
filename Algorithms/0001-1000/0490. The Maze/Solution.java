class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = maze.length, columns = maze[0].length;
        int[][] colors = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maze[i][j] == 1)
                    colors[i][j] = BLOCK;
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        colors[start[0]][start[1]] = GRAY;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0], column = position[1];
            for (int[] direction : directions) {
                int deltaRow = direction[0], deltaColumn = direction[1];
                int stopRow = row, stopColumn = column;
                int curRow = row + deltaRow, curColumn = column + deltaColumn;
                while (curRow >= 0 && curRow < rows && curColumn >= 0 && curColumn < columns && colors[curRow][curColumn] != BLOCK) {
                    stopRow = curRow;
                    stopColumn = curColumn;
                    curRow += deltaRow;
                    curColumn += deltaColumn;
                }
                if (stopRow == destination[0] && stopColumn == destination[1])
                    return true;
                if (colors[stopRow][stopColumn] == WHITE) {
                    colors[stopRow][stopColumn] = GRAY;
                    queue.offer(new int[]{stopRow, stopColumn});
                }
            }
            colors[row][column] = BLACK;
        }
        return false;
    }
}