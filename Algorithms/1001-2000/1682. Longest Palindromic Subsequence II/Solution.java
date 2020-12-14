class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][][] dp = new int[length][length][26];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                for (int k = 0; k < 26; k++) {
                    char c = (char) ('a' + k);
                    if (s.charAt(i) != c)
                        dp[i][j][k] = dp[i + 1][j][k];
                    else if (s.charAt(j) != c)
                        dp[i][j][k] = dp[i][j - 1][k];
                    else {
                        int prevLength = 0;
                        for (int m = 0; m < 26; m++) {
                            if (m != k)
                                prevLength = Math.max(prevLength, dp[i + 1][j - 1][m]);
                        }
                        dp[i][j][k] = prevLength + 2;
                    }
                }
            }
        }
        int maxLength = 0;
        for (int k = 0; k < 26; k++)
            maxLength = Math.max(maxLength, dp[0][length - 1][k]);
        return maxLength;
    }
}