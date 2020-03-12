class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < length; i++)
            dp[i][i] = true;
        for (int i = 0; i < length - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                int curLength = j - i + 1;
                if (curLength > maxLength) {
                    maxLength = curLength;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        for (int i = 1; i < length - 1; i++) {
            int upperBound = Math.min(i, length - i - 1);
            for (int j = 1; j <= upperBound; j++) {
                if (s.charAt(i - j) == s.charAt(i + j) && dp[i - j + 1][i + j - 1]) {
                    dp[i - j][i + j] = true;
                    int curLength = 2 * j + 1;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                        startIndex = i - j;
                        endIndex = i + j;
                    }
                }
            }
        }
        for (int i = 1; i < length - 2; i++) {
            int upperBound = Math.min(i, length - i - 2);
            for (int j = 1; j <= upperBound; j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j) && dp[i - j + 1][i + j]) {
                    dp[i - j][i + j + 1] = true;
                    int curLength = 2 * j + 2;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                        startIndex = i - j;
                        endIndex = i + 1 + j;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}