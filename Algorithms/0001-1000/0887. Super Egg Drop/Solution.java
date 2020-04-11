class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++)
                dp[i][j] = i;
        }
        dp[1][0] = 0;
        for (int i = 1; i <= K; i++)
            dp[1][i] = 1;
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int low = 1, high = i;
                while (low < high) {
                    int mid = (high - low + 1) / 2 + low;
                    int remain1 = dp[mid - 1][j - 1];
                    int remain2 = dp[i - mid][j];
                    if (remain1 > remain2)
                        high = mid - 1;
                    else
                        low = mid;
                }
                dp[i][j] = Math.max(dp[low - 1][j - 1], dp[i - low][j]) + 1;
            }
        }
        return dp[N][K];
    }
}