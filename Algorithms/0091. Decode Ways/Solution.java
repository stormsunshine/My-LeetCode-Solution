class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                dp[i] = 0;
            else {
                int num = Integer.parseInt(s.substring(i, i + 2));
                dp[i] = num <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }
}