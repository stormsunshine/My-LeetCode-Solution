class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[] dp = new int[n];
        int minWindow = n - m + 1;
        for (int j = minWindow - 1; j < n; j++) {
            int start = j - minWindow + 1;
            dp[start] = Math.max(nums[start] * multipliers[m - 1], nums[j] * multipliers[m - 1]);
        }
        for (int i = 2; i <= m; i++) {
            int[] dpNew = new int[n];
            int window = n - m + i;
            for (int j = window - 1; j < n; j++) {
                int start = j - window + 1;
                dpNew[start] = Math.max(dp[start + 1] + nums[start] * multipliers[m - i], dp[start] + nums[j] * multipliers[m - i]);
            }
            dp = dpNew;
        }
        return dp[0];
    }
}