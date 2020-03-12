class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int min = d, max = d * f;
        if (target < min || target > max)
            return 0;
        if (d == 1 || target == min || target == max)
            return 1;
        final int MODULO = 1000000007;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                int upper = Math.min(f, j);
                for (int k = 1; k <= upper; k++)
                    dp[j] = (dp[j] + dp[j - k]) % MODULO;
            }
        }
        return dp[target];
    }
}