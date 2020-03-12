class Solution {
    public int numberOfWays(int num_people) {
        int numPairs = num_people / 2;
        if (numPairs == 0 || numPairs == 1)
            return 1;
        final int MODULO = 1000000007;
        long[] dp = new long[numPairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= numPairs; i++) {
            for (int j = 0; j < i; j++)
                dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % MODULO;
        }
        return (int) (dp[numPairs] % MODULO);
    }
}