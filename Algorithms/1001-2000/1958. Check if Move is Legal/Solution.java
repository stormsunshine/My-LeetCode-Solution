class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        if (rMove >= 2) {
            if (isGoodLine(board, rMove, cMove, color, -1, 0))
                return true;
        }
        if (rMove < 6) {
            if (isGoodLine(board, rMove, cMove, color, 1, 0))
                return true;
        }
        if (cMove >= 2) {
            if (isGoodLine(board, rMove, cMove, color, 0, -1))
                return true;
        }
        if (cMove < 6) {
            if (isGoodLine(board, rMove, cMove, color, 0, 1))
                return true;
        }
        if (rMove >= 2 && cMove >= 2) {
            if (isGoodLine(board, rMove, cMove, color, -1, -1))
                return true;
        }
        if (rMove < 6 && cMove < 6) {
            if (isGoodLine(board, rMove, cMove, color, 1, 1))
                return true;
        }
        if (rMove >= 2 && cMove < 6) {
            if (isGoodLine(board, rMove, cMove, color, -1, 1))
                return true;
        }
        if (rMove < 6 && cMove >= 2) {
            if (isGoodLine(board, rMove, cMove, color, 1, -1))
                return true;
        }
        return false;
    }

    public boolean isGoodLine(char[][] board, int rMove, int cMove, char color, int rDelta, int cDelta) {
        int rEndpoint = -1, cEndpoint = -1;
        for (int i = rMove + rDelta * 2, j = cMove + cDelta * 2; i >= 0 && i < 8 && j >= 0 && j < 8; i += rDelta, j += cDelta) {
            if (board[i][j] == color) {
                rEndpoint = i;
                cEndpoint = j;
                break;
            }
        }
        if (rEndpoint < 0 || cEndpoint < 0)
            return false;
        char midColor = color == 'W' ? 'B' : 'W';
        for (int i = rMove + rDelta, j = cMove + cDelta; i != rEndpoint || j != cEndpoint; i += rDelta, j += cDelta) { 
            if (board[i][j] != midColor)
                return false;
        }
        return true;
    }
}