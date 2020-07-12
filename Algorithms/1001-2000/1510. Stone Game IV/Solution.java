class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++)
            dp[i * i] = true;
        for (int i = 2; i <= n; i++) {
            if (!dp[i]) {
                int curSqrt = (int) Math.sqrt(i);
                boolean flag = false;
                for (int j = 1; j <= curSqrt; j++) {
                    if (!dp[i - j * j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    dp[i] = true;
                else
                    dp[i] = false;
            }
        }
        return dp[n];
    }
}