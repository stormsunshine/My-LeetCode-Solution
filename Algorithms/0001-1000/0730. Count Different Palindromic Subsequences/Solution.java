class Solution {
    public int countPalindromicSubsequences(String S) {
        final int MODULO = 1000000007;
        int length = S.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = 1;
        for (int i = length - 2; i >= 0; i--) {
            char c1 = S.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char c2 = S.charAt(j);
                if (c1 == c2) {
                    int low = i + 1, high = j - 1;
                    while (low <= high && S.charAt(low) != c1)
                        low++;
                    while (low <= high && S.charAt(high) != c2)
                        high--;
                    if (low > high)
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    else if (low == high)
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    else
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                } else
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                dp[i][j] %= MODULO;
                if (dp[i][j] < 0)
                    dp[i][j] += MODULO;
            }
        }
        return dp[0][length - 1];
    }
}