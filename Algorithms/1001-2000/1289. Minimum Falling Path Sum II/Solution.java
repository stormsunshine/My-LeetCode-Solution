class Solution {
    public int minFallingPathSum(int[][] arr) {
        int side = arr.length;
        if (side <= 1)
            return 0;
        int[][] dp = new int[side][side];   
        for (int i = 0; i < side; i++)
            dp[0][i] = arr[0][i];
        for (int i = 1; i < side; i++) {
            int[] minPrevRow = new int[side];
            System.arraycopy(dp[i - 1], 0, minPrevRow, 0, side);
            Arrays.sort(minPrevRow);
            int min1 = minPrevRow[0], min2 = minPrevRow[1];
            if (min1 == min2) {
                for (int j = 0; j < side; j++)
                    dp[i][j] = min1 + arr[i][j];
            } else {
                int minIndex = 0;
                for (int j = 0; j < side; j++) {
                    if (dp[i - 1][j] == min1) {
                        minIndex = j;
                        break;
                    }
                }
                for (int j = 0; j < side; j++) {
                    int prevMin = j == minIndex ? min2 : min1;
                    dp[i][j] = prevMin + arr[i][j];
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < side; i++)
            minSum = Math.min(minSum, dp[side - 1][i]);
        return minSum;
    }
}