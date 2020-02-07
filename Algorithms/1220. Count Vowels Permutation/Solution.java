class Solution {
    public int countVowelPermutation(int n) {
        final int MODULO = 1000000007;
        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MODULO;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MODULO;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MODULO;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MODULO;
        }
        long sum = 0;
        for (int i = 0; i < 5; i++)
            sum += dp[n - 1][i];
        int count = (int) (sum % MODULO);
        return count;
    }
}