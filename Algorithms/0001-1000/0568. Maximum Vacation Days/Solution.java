class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (flights == null || days == null || flights.length == 0 || days.length == 0)
            return 0;
        int cities = days.length, weeks = days[0].length;
        int[][] dp = new int[weeks][cities];
        for (int i = 0; i < weeks; i++) {
            for (int j = 0; j < cities; j++)
                dp[i][j] = -1;
        }
        dp[0][0] = days[0][0];
        for (int i = 1; i < cities; i++) {
            if (flights[0][i] == 1)
                dp[0][i] = days[i][0];
        }
        for (int i = 1; i < weeks; i++) {
            for (int j = 0; j < cities; j++) {
                int maxPrevVacationDays = dp[i - 1][j];
                for (int k = 0; k < cities; k++) {
                    if ((k == j || flights[k][j] == 1) && dp[i - 1][k] >= 0)
                        maxPrevVacationDays = Math.max(maxPrevVacationDays, dp[i - 1][k]);
                }
                if (maxPrevVacationDays >= 0)
                    dp[i][j] = maxPrevVacationDays + days[j][i];
            }
        }
        int maxVacationDays = 0;
        for (int i = 0; i < cities; i++)
            maxVacationDays = Math.max(maxVacationDays, dp[weeks - 1][i]);
        return maxVacationDays;
    }
}