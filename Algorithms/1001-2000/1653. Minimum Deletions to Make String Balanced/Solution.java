class Solution {
    public int minimumDeletions(String s) {
        int length = s.length();
        int[][] dp = new int[length][2];
        if (s.charAt(0) == 'a')
            dp[0][1] = 1;
        else
            dp[0][0] = 1;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }
}