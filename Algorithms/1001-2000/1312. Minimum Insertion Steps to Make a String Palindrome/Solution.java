class Solution {
    public int minInsertions(String s) {
        if (s.length() <= 1)
            return 0;
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String reverseStr = sb.toString();
        int longestCommonSubsequence = longestCommonSubsequence(s, reverseStr);
        return s.length() - longestCommonSubsequence;
    }

    public int longestCommonSubsequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int commonLength = dp[length1][length2];
        return commonLength;
    }
}