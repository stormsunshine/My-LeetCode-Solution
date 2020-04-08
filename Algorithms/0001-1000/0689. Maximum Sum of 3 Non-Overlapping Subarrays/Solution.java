class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        return maxSumOfNSubarrays(nums, k, 3);
    }

    public int[] maxSumOfNSubarrays(int[] nums, int k, int n) {
        if (nums == null || k < 1 || n * k > nums.length)
            return new int[0];
        int length = nums.length;
        int[] prefixSums = new int[length];
        for (int i = 0; i < k; i++)
            prefixSums[k - 1] += nums[i];
        for (int i = k; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] - nums[i - k] + nums[i];
        int[][] dp = new int[length][n];
        int[][] path = new int[length][n];
        dp[k - 1][0] = prefixSums[k - 1];
        path[k - 1][0] = k - 1;
        for (int i = k; i < length; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                path[i][j] = path[i - 1][j];
                int prevSum = j == 0 ? prefixSums[i] : prefixSums[i] + dp[i - k][j - 1];
                if (prevSum > dp[i][j]) {
                    dp[i][j] = prevSum;
                    path[i][j] = i;
                }
            }
        }
        int[] subarrays = new int[n];
        int index = path[length - 1][n - 1];
        subarrays[n - 1] = index - k + 1;
        for (int i = n - 2; i >= 0; i--) {
            index = path[index - k][i];
            subarrays[i] = index - k + 1;
        }
        return subarrays;
    }
}