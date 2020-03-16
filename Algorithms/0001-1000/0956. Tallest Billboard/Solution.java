class Solution {
    public int tallestBillboard(int[] rods) {
        int rows = rods.length;
        if (rows < 2)
            return 0;
        int sum = 0;
        for (int rod : rods)
            sum += rod;
        int columns = sum * 2 + 1;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                dp[i][j] = -1;
        }
        dp[0][sum + rods[0]] = rods[0];
        dp[0][sum] = 0;
        dp[0][sum - rods[0]] = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (dp[i - 1][j] >= 0) {
                    int rod = rods[i];
                    dp[i][j + rod] = Math.max(dp[i][j + rod], dp[i - 1][j] + rod);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    dp[i][j - rod] = Math.max(dp[i][j - rod], dp[i - 1][j]);
                }
            }
        }
        int maxHeight = 0;
        for (int i = 0; i < rows; i++)
            maxHeight = Math.max(maxHeight, dp[i][sum]);
        return maxHeight;
    }
}