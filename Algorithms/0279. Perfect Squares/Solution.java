class Solution {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n)
            return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = i;
        for (int i = 1; i <= sqrt; i++)
            dp[i * i] = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i] == i) {
                int maxSqrt = (int) Math.sqrt(i);
                for (int j = 1; j <= maxSqrt; j++) {
                    int prev = dp[i - j * j];
                    dp[i] = Math.min(dp[i], prev + 1);
                }
            }
        }
        return dp[n];
    }
}