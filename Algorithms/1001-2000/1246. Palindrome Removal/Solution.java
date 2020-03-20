class Solution {
    public int minimumMoves(int[] arr) {
        int length = arr.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++)
                dp[i][j] = j - i + 1;
        }
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] == arr[i])
                dp[i - 1][i] = 1;
        }
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i + 1][j - 1];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++)
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][length - 1];
    }
}