class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        int[][] dp = new int[tLength + 1][sLength + 1];
        for (int i = 0; i <= sLength; i++)
            dp[tLength][i] = 1;
        for (int i = tLength - 1; i >= 0; i--) {
            int tChar = t.charAt(i);
            for (int j = sLength - 1; j >= 0; j--) {
                if (tChar == s.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + dp[i][j + 1];
                else
                    dp[i][j] = dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}