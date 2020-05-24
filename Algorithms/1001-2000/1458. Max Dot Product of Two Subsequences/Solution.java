class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++)
                dp[i][j] = Integer.MIN_VALUE;
        }
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < length1; i++) {
            int currProduct = nums1[i] * nums2[0];
            dp[i][0] = Math.max(dp[i - 1][0], currProduct);
        }
        for (int j = 1; j < length2; j++) {
            int currProduct = nums1[0] * nums2[j];
            dp[0][j] = Math.max(dp[0][j - 1], currProduct);
        }
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                int currProduct = nums1[i] * nums2[j];
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), Math.max(Math.max(dp[i - 1][j - 1], currProduct), dp[i - 1][j - 1] + currProduct));
            }
        }
        return dp[length1 - 1][length2 - 1];
    }
}