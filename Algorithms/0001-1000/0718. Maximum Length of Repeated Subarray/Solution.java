class Solution {
    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        int length1 = A.length, length2 = B.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}