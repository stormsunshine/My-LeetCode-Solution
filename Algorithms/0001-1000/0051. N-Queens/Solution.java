class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] emptyChessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                emptyChessboard[i][j] = '.';
        }
        List<char[][]> chessboardList = backtrack(emptyChessboard, n, 0);
        List<List<String>> chessboardStrList = new ArrayList<List<String>>();
        for (char[][] chessboard : chessboardList) {
            List<String> chessboardStr = arrayToList(chessboard);
            chessboardStrList.add(chessboardStr);
        }
        return chessboardStrList;
    }

    public List<char[][]> backtrack(char[][] chessboard, int n, int count) {
        List<char[][]> list = new ArrayList<char[][]>();
        if (count == n) {
            char[][] curChessboard = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    curChessboard[i][j] = chessboard[i][j];
            }
            list.add(curChessboard);
            return list;
        }
        for (int i = 0; i < n; i++) {
            if (isLegal(chessboard, count, i)) {
                chessboard[count][i] = 'Q';
                List<char[][]> curList = backtrack(chessboard, n, count + 1);
                list.addAll(curList);
                chessboard[count][i] = '.';
            }
        }
        return list;
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

    public List<String> arrayToList(char[][] chessboard) {
        List<String> list = new ArrayList<String>();
        for (char[] row : chessboard)
            list.add(new String(row));
        return list;
    }
}