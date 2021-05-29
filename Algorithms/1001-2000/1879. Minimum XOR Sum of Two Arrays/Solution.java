class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[][] dp = new int[length][1 << length];
        for (int i = 0; i < length; i++)
            dp[0][1 << i] = nums1[0] ^ nums2[i];
        for (int i = 1; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 1; j < 1 << length; j++) {
                int remain = j;
                while (remain > 0) {
                    int curBit = remain & (-remain);
                    if ((j & curBit) != 0) {
                        int k = (int) (Math.log(curBit) / Math.log(2));
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - curBit] + (nums1[i] ^ nums2[k]));
                    }
                    remain -= curBit;
                }
            }
        }
        return dp[length - 1][(1 << length) - 1];
    }
}