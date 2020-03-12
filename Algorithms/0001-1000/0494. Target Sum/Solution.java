class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int difference = sum - S;
        if (difference < 0 || difference % 2 != 0)
            return 0;
        int maxValue = difference / 2;
        int[] dp = new int[maxValue + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = maxValue; i >= num; i--)
                dp[i] += dp[i - num];
        }
        return dp[maxValue];
    }
}