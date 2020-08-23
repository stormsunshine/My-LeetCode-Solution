class Solution {
    public int stoneGameV(int[] stoneValue) {
        int length = stoneValue.length;
        int[] prefix = new int[length];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < length; i++)
            prefix[i] = prefix[i - 1] + stoneValue[i];
        int[][] dp = new int[length][length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                for (int k = i; k < j; k++) {
                    int score1 = getSubarraySum(prefix, i, k);
                    int score2 = getSubarraySum(prefix, k + 1, j);
                    int curScore = 0;
                    if (score1 <= score2)
                        curScore = Math.max(curScore, score1 + dp[i][k]);
                    if (score1 >= score2)
                        curScore = Math.max(curScore, score2 + dp[k + 1][j]);
                    dp[i][j] = Math.max(dp[i][j], curScore);
                }
            }
        }
        return dp[0][length - 1];
    }

    public int getSubarraySum(int[] prefix, int start, int end) {
        if (start == 0)
            return prefix[end];
        else
            return prefix[end] - prefix[start - 1];
    }
}