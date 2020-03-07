class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int max = 0;
                for (int k = j - i; k <= j; k++) {
                    int midScore = (j - i - 1 < 0 ? 1 : nums[j - i - 1]) * nums[k] * (j + 1 > length - 1 ? 1 : nums[j + 1]);
                    int leftScore = j - i > k - 1 ? 0 : dp[j - i][k - 1];
                    int rightScore = j < k + 1 ? 0 : dp[k + 1][j];
                    max = Math.max(max, midScore + leftScore + rightScore);
                }
                dp[j - i][j] = max;
            }
        }
        return dp[0][length - 1];
    }
}