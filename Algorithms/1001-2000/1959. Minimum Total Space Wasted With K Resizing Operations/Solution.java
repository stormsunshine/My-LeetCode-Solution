class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int length = nums.length;
        int[][] dp = new int[k + 1][length];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int sum = 0, maxSize = 0;
                for (int l = j; l >= i; l--) {
                    sum += nums[l];
                    maxSize = Math.max(maxSize, nums[l]);
                    if (i > 0 || l == 0)
                        dp[i][j] = Math.min(dp[i][j], (l > 0 ? dp[i - 1][l - 1] : 0) + (maxSize * (j - l + 1) - sum));
                }
            }
        }
        return dp[k][length - 1];
    }
}