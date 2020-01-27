class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null)
            return -1;
        int length = jobDifficulty.length;
        if (length < d)
            return -1;
        if (length == d) {
            int sum = 0;
            for (int difficulty : jobDifficulty)
                sum += difficulty;
            return sum;
        }
        int[] maxDifficultyRight = new int[length];
        maxDifficultyRight[length - 1] = jobDifficulty[length - 1];
        for (int i = length - 2; i >= 0; i--)
            maxDifficultyRight[i] = Math.max(maxDifficultyRight[i + 1], jobDifficulty[i]);
        int[][] dp = new int[d][length];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i <= length - d; i++)
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        for (int i = 1; i < d; i++) {
            int start = i, end = length - d + i;
            int prevEnd = start - 1;
            for (int j = start; j <= end; j++) {
                dp[i][j] = dp[i - 1][j - 1] + jobDifficulty[j];
                int max = jobDifficulty[j];
                for (int k = j - 2; k >= prevEnd; k--) {
                    max = Math.max(max, jobDifficulty[k + 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + max);
                }
            }
        }
        return dp[d - 1][length - 1];
    }
}