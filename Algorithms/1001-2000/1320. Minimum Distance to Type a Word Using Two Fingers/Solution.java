class Solution {
    public int minimumDistance(String word) {
        int length = word.length();
        int[][] dp = new int[length][length];
        int[][] distances = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++)
                distances[i][j] = distance(word.charAt(i) - 'A', word.charAt(j) - 'A');
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++)
                dp[i][j] = Integer.MAX_VALUE;
            for (int j = 0; j < i - 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + distances[i - 1][i]);
                dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + distances[j][i]);
            }
            dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][i - 1]);
            dp[i][i] = dp[i - 1][i - 1] + distances[i - 1][i];
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++)
            minDistance = Math.min(minDistance, dp[length - 1][i]);
        return minDistance;
    }

    public int distance(int position1, int position2) {
        int x1 = position1 / 6, y1 = position1 % 6;
        int x2 = position2 / 6, y2 = position2 % 6;
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}