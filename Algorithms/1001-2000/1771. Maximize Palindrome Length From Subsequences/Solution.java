class Solution {
    public int longestPalindrome(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        sb.append(word1);
        sb.append(word2);
        String concat = sb.toString();
        int length1 = word1.length(), length2 = word2.length(), length3 = concat.length();
        int[][] dp = new int[length3][length3];
        boolean[][] twoParts = new boolean[length3][length3];
        for (int i = 0; i < length3; i++) {
            dp[i][i] = 1;
            twoParts[i][i] = false;
        }
        int maxLength = 0;
        for (int i = length3 - 2; i >= 0; i--) {
            for (int j = i + 1; j < length3; j++) {
                if (concat.charAt(i) == concat.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    twoParts[i][j] = twoParts[i + 1][j - 1];
                    if (!twoParts[i][j])
                        twoParts[i][j] = i < length1 && j >= length1;
                } else {
                    if (dp[i][j - 1] >= dp[i + 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                        twoParts[i][j] = twoParts[i][j - 1];
                    }
                    if (dp[i][j - 1] <= dp[i + 1][j]) {
                        dp[i][j] = dp[i + 1][j];
                        twoParts[i][j] = twoParts[i][j] || twoParts[i + 1][j];
                    }
                }
                if (twoParts[i][j])
                    maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}