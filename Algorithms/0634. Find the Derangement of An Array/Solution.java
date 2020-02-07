class Solution {
    public int findDerangement(int n) {
        if (n <= 3)
            return n - 1;
        final int MODULO = 1000000007;
        long[] dp = new long[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) * i % MODULO;
        return (int) dp[n - 1];
    }
}