class Solution {
    public int racecar(int target) {
        int[] dp = new int[Math.max(target + 3, target * 2)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;
        for (int i = 3; i <= target; i++) {
            int bits = (int) (Math.log(i) / Math.log(2)) + 1;
            if (i == (1 << bits) - 1)
                dp[i] = bits;
            else {
                for (int j = 0; j < bits - 1; j++)
                    dp[i] = Math.min(dp[i], dp[i - (1 << (bits - 1)) + (1 << j)] + bits - 1 + j + 2);
                if ((1 << bits) - 1 - i < i)
                    dp[i] = Math.min(dp[i], dp[(1 << bits) - 1 - i] + bits + 1);
            }
        }
        return dp[target];
    }
}