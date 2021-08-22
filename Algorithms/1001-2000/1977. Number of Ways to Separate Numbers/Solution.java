class Solution {
    public int numberOfCombinations(String num) {
        final int MODULO = 1000000007;
        if (num.charAt(0) == '0')
            return 0;
        int length = num.length();
        int[][] lcp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            lcp[i][length - 1] = num.charAt(i) == num.charAt(length - 1) ? 1 : 0;
            for (int j = i + 1; j < length - 1; j++)
                lcp[i][j] = num.charAt(i) == num.charAt(j) ? lcp[i + 1][j + 1] + 1 : 0;
        }
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++)
            dp[0][i] = 1;
        for (int i = 1; i < length; i++) {
            if (num.charAt(i) == '0')
                continue;
            int presum = 0;
            for (int j = i; j < length; ++j) {
                int range = j - i + 1;
                dp[i][j] = presum;
                if (i - range >= 0) {
                    if (lcp[i - range][i] >= range || num.charAt(i - range + lcp[i - range][i]) < num.charAt(i + lcp[i - range][i]))
                        dp[i][j] = (dp[i][j] + dp[i - range][i - 1]) % MODULO;
                    presum = (presum + dp[i - range][i - 1]) % MODULO;
                }
            }
        }
        int ways = 0;
        for (int i = 0; i < length; i++)
            ways = (ways + dp[i][length - 1]) % MODULO;
        return ways;
    }
}