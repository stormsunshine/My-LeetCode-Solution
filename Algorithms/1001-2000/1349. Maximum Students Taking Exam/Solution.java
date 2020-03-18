class Solution {
    public int maxStudents(char[][] seats) {
        int rows = seats.length, columns = seats[0].length;
        int[][] dp = new int[rows][1 << columns];
        for (int state = 0; state < 1 << columns; state++) {
            if (isLegal(seats, 0, state))
                dp[0][state] = Integer.bitCount(state);
        }
        for (int i = 1; i < rows; i++) {
            for (int state1 = 0; state1 < 1 << columns; state1++) {
                for (int state2 = 0; state2 < 1 << columns; state2++) {
                    if (isLegal(seats, i - 1, state1) && isLegal(seats, i, state2) && isLegal(state1, state2))
                        dp[i][state2] = Math.max(dp[i][state2], dp[i - 1][state1] + Integer.bitCount(state2));
                }
            }
        }
        int maxStudents = 0;
        for (int state = 0; state < 1 << columns; state++)
            maxStudents = Math.max(maxStudents, dp[rows - 1][state]);
        return maxStudents;
    }

    public boolean isLegal(char[][] seats, int row, int state) {
        if ((state << 1 & state) != 0 || (state >> 1 & state) != 0)
            return false;
        int columns = seats[0].length;
        boolean[] curRow = new boolean[columns];
        for (int i = columns - 1; i >= 0; i--) {
            curRow[i] = state % 2 == 1;
            state /= 2;
        }
        for (int i = 0; i < columns; i++) {
            if (seats[row][i] == '#' && curRow[i])
                return false;
        }
        return true;
    }

    public boolean isLegal(int state1, int state2) {
        return (state1 << 1 & state2) == 0 && (state1 >> 1 & state2) == 0;
    }
}