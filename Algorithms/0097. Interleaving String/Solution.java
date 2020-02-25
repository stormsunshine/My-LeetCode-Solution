class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length1 + length2 != length3)
            return false;
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else {
                    if (i > 0)
                        dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    if (j > 0)
                        dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[length1][length2];
    }
}