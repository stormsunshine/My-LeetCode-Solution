class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int length = nums.length;
        if (length < 2)
            return false;
        int target = sum / 2;
        if (nums[length - 1] > target)
            return false;
        else if (nums[length - 1] == target)
            return true;
        boolean[][] dp = new boolean[length][target + 1];
        for (int i = 0; i < length; i++)
            dp[i][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[length - 1][target];
    }
}