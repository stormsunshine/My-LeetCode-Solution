class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int[] counts = new int[max + 1];
        for (int num : nums)
            counts[num]++;
        int[] dp = new int[max + 1];
        dp[1] = counts[1];
        dp[2] = Math.max(dp[1], 2 * counts[2]);
        for (int i = 3; i <= max; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * counts[i]);
        return dp[max];
    }
}