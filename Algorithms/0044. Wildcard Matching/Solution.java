class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[sLength][pLength] = true;
        for (int i = sLength; i >= 0; i--) {
            for (int j = pLength - 1; j >= 0; j--) {
                if (p.charAt(j) == '*')
                    dp[i][j] = dp[i][j + 1] || i < sLength && dp[i + 1][j];
                else {
                    boolean charMatch = i < sLength && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                    dp[i][j] = charMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}