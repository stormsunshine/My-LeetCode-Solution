class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int minDistance = minDistance(s, t);
        return minDistance == 1;
    }

    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++)
            dp[i][0] = i;
        for (int i = 1; i <= length2; i++)
            dp[0][i] = i;
        for (int i = 1; i <= length1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[length1][length2];
    }
}