class TicTacToe {
    final char[] SIGNALS = {'X', 'O'};
    int side;
    char[][] board;
    int[][] countRows;
    int[][] countColumns;
    int[][] countDiagonals;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        side = n;
        board = new char[n][n];
        countRows = new int[2][n];
        countColumns = new int[2][n];
        countDiagonals = new int[2][2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (board[row][col] != 0 || player != 1 && player != 2)
            return 0;
        int index = player - 1;
        board[row][col] = SIGNALS[index];
        int countRow = countRows[index][row];
        countRow++;
        countRows[index][row] = countRow;
        if (countRow == side)
            return player;
        int countColumn = countColumns[index][col];
        countColumn++;
        countColumns[index][col] = countColumn;
        if (countColumn == side)
            return player;
        if (row == col) {
            int countDiagonal = countDiagonals[index][0];
            countDiagonal++;
            countDiagonals[index][0] = countDiagonal;
            if (countDiagonal == side)
                return player;
        }
        if (row + col == side - 1) {
            int countDiagonal = countDiagonals[index][1];
            countDiagonal++;
            countDiagonals[index][1] = countDiagonal;
            if (countDiagonal == side)
                return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */