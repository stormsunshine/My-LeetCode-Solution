class Solution {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() <= 1)
            return 0;
        int length = S.length();
        int[][] dp = new int[length][2];
        if (S.charAt(0) == '0')
            dp[0][1] = 1;
        else
            dp[0][0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            char c = S.charAt(i);
            if (c == '0')
                dp[i][1]++;
            else
                dp[i][0]++;
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }
}