class Solution {
    int m;
    int n;
    int maxState;
    int mod;
    int[][][][][] dp;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        maxState = (int) Math.pow(3, n);
        mod = maxState / 3;
        dp = new int[m][n][introvertsCount + 1][extrovertsCount + 1][maxState];
        return dp(0, 0, introvertsCount, extrovertsCount, 0);
    }

    public int dp(int row, int column, int introvertsCount, int extrovertsCount, int lastState) {
        if (row == m)
            return 0;
        if (column == n)
            return dp(row + 1, 0, introvertsCount, extrovertsCount, lastState);
        if (dp[row][column][introvertsCount][extrovertsCount][lastState] == 0) {
            int value = dp(row, column + 1, introvertsCount, extrovertsCount, lastState % mod * 3);
            if (introvertsCount != 0) {
                int value1 = 120, up = lastState / mod, left = lastState % 3;
                if (row > 0 && up != 0) {
                    value1 -= 30;
                    value1 += up == 1 ? -30 : 20;
                }
                if (column > 0 && left != 0) {
                    value1 -= 30;
                    value1 += left == 1 ? -30 : 20;
                }
                value = Math.max(value, value1 + dp(row, column + 1, introvertsCount - 1, extrovertsCount, lastState % mod * 3 + 1));
            }
            if (extrovertsCount != 0) {
                int value2 = 40, up = lastState / mod, left = lastState % 3;
                if (row > 0 && up != 0) {
                    value2 += 20;
                    value2 += up == 1 ? -30 : 20;
                }
                if (column > 0 && left != 0) {
                    value2 += 20;
                    value2 += left == 1 ? -30 : 20;
                }
                value = Math.max(value, value2 + dp(row, column + 1, introvertsCount, extrovertsCount - 1, lastState % mod * 3 + 2));
            }
            dp[row][column][introvertsCount][extrovertsCount][lastState] = value;
        }
        return dp[row][column][introvertsCount][extrovertsCount][lastState];
    }
}