class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        final int MODULO = 1000000007;
        int side = board.size();
        char[][] board2D = new char[side][side];
        for (int i = 0; i < side; i++) {
            String row = board.get(i);
            for (int j = 0; j < side; j++)
                board2D[i][j] = row.charAt(j);
        }
        int[][][] dp = new int[side][side][2];
        dp[side - 1][side - 1][0] = 0;
        dp[side - 1][side - 1][1] = 1;
        for (int i = side - 2; i >= 0; i--) {
            char cell = board2D[side - 1][i];
            if (cell == 'X')
                break;
            else {
                dp[side - 1][i][0] = dp[side - 1][i + 1][0] + cell - '0';
                dp[side - 1][i][1] = 1;
            }
        }
        for (int i = side - 2; i >= 0; i--) {
            char cell = board2D[i][side - 1];
            if (cell == 'X')
                break;
            else {
                dp[i][side - 1][0] = dp[i + 1][side - 1][0] + cell - '0';
                dp[i][side - 1][1] = 1;
            }
        }
        for (int i = side - 2; i >= 0; i--) {
            for (int j = side - 2; j >= 0; j--) {
                char curCell = board2D[i][j];
                if (curCell == 'X')
                    continue;
                char downRight = board2D[i + 1][j + 1];
                int curScore = curCell == 'E' ? 0 : curCell - '0';
                int downScore = dp[i + 1][j][0];
                int rightScore = dp[i][j + 1][0];
                int downRightScore = dp[i + 1][j + 1][0];
                if (downScore > 0 && rightScore > 0) {
                    if (downScore > rightScore) {
                        dp[i][j][0] = downScore + curScore;
                        dp[i][j][1] = dp[i + 1][j][1];
                    } else if (downScore < rightScore) {
                        dp[i][j][0] = rightScore + curScore;
                        dp[i][j][1] = dp[i][j + 1][1];
                    } else {
                        if (downScore > 0) {
                            dp[i][j][0] = downScore + curScore;
                            dp[i][j][1] = (dp[i + 1][j][1] + dp[i][j + 1][1]) % MODULO;
                        }
                    }
                } else if (downScore > 0) {
                    dp[i][j][0] = downScore + curScore;
                    dp[i][j][1] = dp[i + 1][j][1];
                } else if (rightScore > 0) {
                    dp[i][j][0] = rightScore + curScore;
                    dp[i][j][1] = dp[i][j + 1][1];
                } else {
                    if (downRightScore > 0 || downRight == 'S') {
                        dp[i][j][0] = downRightScore + curScore;
                        dp[i][j][1] = dp[i + 1][j + 1][1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}