class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int[][] dp = new int[length][4];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][2] + nums[i];
        }
        for (int i = 0; i < 2; i++)
            dp[length - 1][i] = dp[length - 2][i];
        return max(dp[length - 1]);
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array)
            max = Math.max(max, num);
        return max;
    }
}