class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxLength = 1;
        for (int i = 0; i < length; i++)
            maxLength = Math.max(maxLength, dp[i]);
        return maxLength;
    }
}