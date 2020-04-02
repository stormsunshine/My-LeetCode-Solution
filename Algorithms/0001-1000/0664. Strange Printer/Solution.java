class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        if (length == 1)
            return 1;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = 1;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i))
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                }
            }
        }
        return dp[0][length - 1];
    }
}