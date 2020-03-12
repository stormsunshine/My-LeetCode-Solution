class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int maxLength = 1;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int[][] dp2d = new int[length][maxLength + 1];
        for (int i = 0; i < length; i++)
            dp2d[i][0] = 1;
        dp2d[0][1] = 1;
        for (int i = 1; i < length; i++) {
            dp2d[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    for (int k = 1; k < maxLength; k++)
                        dp2d[i][k + 1] += dp2d[j][k];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++)
            count += dp2d[i][maxLength];
        return count;
    }
}