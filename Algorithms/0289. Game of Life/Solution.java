class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, columns = board[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int curValue = board[i][j];
                int liveNeighborsCount = 0;
                for (int[] direction : directions) {
                    int newRow = i + direction[0], newColumn = j + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && board[newRow][newColumn] % 2 == 1)
                        liveNeighborsCount++;
                }
                if (curValue == 1)
                    board[i][j] = liveNeighborsCount == 2 || liveNeighborsCount == 3 ? 1 : 3;
                else
                    board[i][j] = liveNeighborsCount == 3 ? 2 : 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int curValue = board[i][j];
                if (curValue == 2)
                    board[i][j] = 1;
                else if (curValue == 3)
                    board[i][j] = 0;
            }
        }
    }
}