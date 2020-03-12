class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookColumn = -1;
        int rows = board.length, columns = board[0].length;
        int totalSquares = rows * columns;
        for (int i = 0; i < totalSquares; i++) {
            int row = i / columns, column = i % columns;
            if (board[row][column] == 'R') {
                rookRow = row;
                rookColumn = column;
                break;
            }
        }
        if (rookRow < 0 || rookColumn < 0)
            return 0;
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int tempRow = rookRow + direction[0], tempColumn = rookColumn + direction[1];
            while (tempRow >= 0 && tempRow < rows && tempColumn >= 0 && tempColumn < columns) {
                if (board[tempRow][tempColumn] != '.') {
                    if (board[tempRow][tempColumn] == 'p')
                        count++;
                    break;
                }
                tempRow += direction[0];
                tempColumn += direction[1];
            }
        }
        return count;
    }
}