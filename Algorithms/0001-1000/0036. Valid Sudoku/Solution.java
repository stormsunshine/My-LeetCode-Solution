class Solution {
    final int SIDE = 9;
    final int SUBSIDE = 3;

    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkColumns(board) && checkSubboxes(board);
    }

    public boolean checkRows(char[][] board) {
        for (int i = 0; i < SIDE; i++) {
            boolean[] exist = new boolean[SIDE];
            for (int j = 0; j < SIDE; j++) {
                char cellValue = board[i][j];
                if (cellValue == '.')
                    continue;
                int num = cellValue - '0';
                if (exist[num - 1])
                    return false;
                else
                    exist[num - 1] = true;
            }
        }
        return true;
    }

    public boolean checkColumns(char[][] board) {
        for (int i = 0; i < SIDE; i++) {
            boolean[] exist = new boolean[SIDE];
            for (int j = 0; j < SIDE; j++) {
                char cellValue = board[j][i];
                if (cellValue == '.')
                    continue;
                int num = cellValue - '0';
                if (exist[num - 1])
                    return false;
                else
                    exist[num - 1] = true;
            }
        }
        return true;
    }

    public boolean checkSubboxes(char[][] board) {
        for (int rowBegin = 0; rowBegin < SIDE; rowBegin += SUBSIDE) {
            int rowEnd = rowBegin + SUBSIDE - 1;
            for (int columnBegin = 0; columnBegin < SIDE; columnBegin += SUBSIDE) {
                int columnEnd = columnBegin + SUBSIDE - 1;
                boolean[] exist = new boolean[SIDE];
                for (int i = rowBegin; i <= rowEnd; i++) {
                    for (int j = columnBegin; j <= columnEnd; j++) {
                        char cellValue = board[i][j];
                        if (cellValue == '.')
                            continue;
                        int num = cellValue - '0';
                        if (exist[num - 1])
                            return false;
                        else
                            exist[num - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}