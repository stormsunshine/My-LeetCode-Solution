class Solution {
    public int countSpecialSubsequences(int[] nums) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[][] dp = new int[length][3];
        if (nums[0] == 0)
            dp[0][0] = 1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num == 0)
                dp[i][0] = (dp[i - 1][0] * 2 + 1) % MODULO;
            else
                dp[i][0] = dp[i - 1][0];
            if (num == 1) {
                dp[i][1] = dp[i - 1][1] * 2 % MODULO;
                dp[i][1] = (dp[i][1] + dp[i - 1][0]) % MODULO;
            } else
                dp[i][1] = dp[i - 1][1];
            if (num == 2) {
                dp[i][2] = dp[i - 1][2] * 2 % MODULO;
                dp[i][2] = (dp[i][2] + dp[i - 1][1]) % MODULO;
            } else
                dp[i][2] = dp[i - 1][2];
        }
        return dp[length - 1][2];
    }
}