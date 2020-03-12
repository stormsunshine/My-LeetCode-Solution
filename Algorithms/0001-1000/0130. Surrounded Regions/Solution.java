class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int rows = board.length, columns = board[0].length;
        for (int i = 0; i < columns; i++) {
            depthFirstSearch(board, 0, i, 'O', 'B');
            depthFirstSearch(board, rows - 1, i, 'O', 'B');
        }
        for (int i = 0; i < rows; i++) {
            depthFirstSearch(board, i, 0, 'O', 'B');
            depthFirstSearch(board, i, columns - 1, 'O', 'B');
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'B')
                    board[i][j] = 'O';
            }
        }
    }

    public void depthFirstSearch(char[][] board, int row, int column, char originalSymbol, char newSymbol) {
        if (board[row][column] != originalSymbol)
            return;
        board[row][column] = newSymbol;
        int rows = board.length, columns = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns)
                depthFirstSearch(board, newRow, newColumn, originalSymbol, newSymbol);
        }
    }
}