class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length())
            return false;
        int length = s1.length();
        boolean[][][] dp = new boolean[length][length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
        }
        for (int curLength = 2; curLength <= length; curLength++) {
            int maxStart = length - curLength;
            for (int i = 0; i <= maxStart; i++) {
                for (int j = 0; j <= maxStart; j++) {
                    for (int k = 1; k < curLength; k++) {
                        if (dp[i][j][k - 1] && dp[i + k][j + k][curLength - k - 1]) {
                            dp[i][j][curLength - 1] = true;
                            break;
                        }
                        if (dp[i][j + curLength - k][k - 1] && dp[i + k][j][curLength - k - 1]) {
                            dp[i][j][curLength - 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][length - 1];
    }
}