class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], column = click[1];
        if (board[row][column] == 'M')
            board[row][column] = 'X';
        else if (board[row][column] == 'E')
            breadthFirstSearch(board, row, column);
        return board;
    }

    public void breadthFirstSearch(char[][] board, int row, int column) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int rows = board.length, columns = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            if (board[curRow][curColumn] != 'E')
                continue;
            int adjacentMines = 0;
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    char status = board[newRow][newColumn];
                    if (status == 'M')
                        adjacentMines++;
                }
            }
            if (adjacentMines > 0)
                board[curRow][curColumn] = (char) ('0' + adjacentMines);
            else {
                for (int[] direction : directions) {
                    int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                        char status = board[newRow][newColumn];
                        if (status == 'E')
                            queue.offer(new int[]{newRow, newColumn});
                    }
                }
                board[curRow][curColumn] = 'B';
            }
        }
    }
}