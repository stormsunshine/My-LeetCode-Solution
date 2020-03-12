class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int maxOrder = 0;
        Set<String> minesSet = new HashSet<String>();
        for (int[] mine : mines)
            minesSet.add(Arrays.toString(mine));
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                int[] cell = {i, j};
                if (minesSet.contains(Arrays.toString(cell)))
                    count = 0;
                else
                    count++;
                dp[i][j] = count;
            }
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                int[] cell = {i, j};
                if (minesSet.contains(Arrays.toString(cell)))
                    count = 0;
                else
                    count++;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                int[] cell = {j, i};
                if (minesSet.contains(Arrays.toString(cell)))
                    count = 0;
                else
                    count++;
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                int[] cell = {j, i};
                if (minesSet.contains(Arrays.toString(cell)))
                    count = 0;
                else
                    count++;
                dp[j][i] = Math.min(dp[j][i], count);
                maxOrder = Math.max(maxOrder, dp[j][i]);
            }
        }
        return maxOrder;
    }
}