class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int length1 = A.length, length2 = B.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            int num1 = A[i - 1];
            for (int j = 1; j <= length2; j++) {
                int num2 = B[j - 1];
                if (num1 == num2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[length1][length2];
    }
}