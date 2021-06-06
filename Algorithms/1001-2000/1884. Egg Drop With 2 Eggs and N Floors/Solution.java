class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int curr = Math.max(dp[j - 1][0], dp[i - j][1]) + 1;
                dp[i][1] = Math.min(dp[i][1], curr);
            }
        }
        return dp[n][1];
    }
}