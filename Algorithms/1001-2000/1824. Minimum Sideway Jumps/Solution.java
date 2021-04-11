class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        final int INFINITY = n * 2;
        int[][] dp = new int[n + 1][4];
        dp[0][1] = dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            int obstacle = obstacles[i];
            for (int j = 1; j <= 3; j++)
                dp[i][j] = dp[i - 1][j];
            if (obstacle > 0)
                dp[i][obstacle] = INFINITY;
            for (int j = 1; j <= 3; j++) {
                if (j != obstacle) {
                    for (int k = 1; k <= 3; k++) {
                        if (j != k && k != obstacle)
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + 1);
                    }
                }
            }
        }
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++)
            minJumps = Math.min(minJumps, dp[n][i]);
        return minJumps;
    }
}