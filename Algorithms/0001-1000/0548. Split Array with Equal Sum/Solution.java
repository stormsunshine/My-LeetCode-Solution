class Solution {
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7)
            return false;
        int length = nums.length;
        Set<Integer>[][] dp = new Set[length][5];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= 4; j++)
                dp[i][j] = new HashSet<Integer>();
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            dp[i][1].add(sum);
        }
        for (int i = 2; i < length; i++) {
            for (int j = 2; j <= 4; j++) {
                sum = 0;
                for (int k = i; k >= 2; k--) {
                    sum += nums[k];
                    if (dp[k - 2][j - 1].contains(sum))
                        dp[i][j].add(sum);
                }
            }
        }
        return dp[length - 1][4].size() > 0;
    }
}