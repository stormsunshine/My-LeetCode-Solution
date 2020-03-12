class Solution {
    public int totalNQueens(int n) {
        char[][] emptyChessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                emptyChessboard[i][j] = '.';
        }
        int total = backtrack(emptyChessboard, n, 0);
        return total;
    }

    public int backtrack(char[][] chessboard, int n, int count) {
        if (count == n)
            return 1;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (isLegal(chessboard, count, i)) {
                chessboard[count][i] = 'Q';
                int curTotal = backtrack(chessboard, n, count + 1);
                total += curTotal;
                chessboard[count][i] = '.';
            }
        }
        return total;
    }

    public boolean isLegal(char[][] chessboard, int count, int index) {
        int n = chessboard.length;
        for (int i = count - 1; i >= 0; i--) {
            if (chessboard[i][index] == 'Q')
                return false;
        }
        for (int i = count - 1, j = index - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        for (int i = count - 1, j = index + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;
    }
}