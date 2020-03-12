class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (visited[i][j] || board[i][j] == '.')
                    continue;
                visited[i][j] = true;
                for (int k = i - 1; k >= 0 && board[k][j] == 'X'; k--)
                    visited[k][j] = true;
                for (int k = i + 1; k < rows && board[k][j] == 'X'; k++)
                    visited[k][j] = true;
                for (int k = j - 1; k >= 0 && board[i][k] == 'X'; k--)
                    visited[i][k] = true;
                for (int k = j + 1; k < columns && board[i][k] == 'X'; k++)
                    visited[i][k] = true;
                count++;
            }
        }
        return count;
    }
}