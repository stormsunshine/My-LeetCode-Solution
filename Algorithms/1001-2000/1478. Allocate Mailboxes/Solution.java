class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int length = houses.length;
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i <= length; i++)
            Arrays.fill(dp[i], -1);
        int[][] distances = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                for (int x = i, y = j; x < y; x++, y--)
                    distances[i][j] += houses[y - 1] - houses[x - 1];
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                for (int p = i; p >= 1; p--) {
                    if (dp[p - 1][j - 1] != -1 && (dp[i][j] == -1 || dp[i][j] > dp[p - 1][j - 1] + distances[p][i]))
                        dp[i][j] = dp[p - 1][j - 1] + distances[p][i];
                }
            }
        }
        return dp[length][k];
    }
}