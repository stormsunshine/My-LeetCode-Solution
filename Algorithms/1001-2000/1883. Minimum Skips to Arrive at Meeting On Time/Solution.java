class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int length = dist.length;
        long[][] dp = new long[length + 1][length + 1];
        for (int i = 0; i <= length; i++)
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        dp[0][0] = 0;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != i)
                    dp[i][j] = Math.min(dp[i][j], ((dp[i - 1][j] + dist[i - 1] - 1) / speed + 1) * speed);
                if (j != 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
            }
        }
        for (int j = 0; j <= length; j++) {
            if (dp[length][j] <= (long) hoursBefore * speed)
                return j;
        }
        return -1;
    }
}