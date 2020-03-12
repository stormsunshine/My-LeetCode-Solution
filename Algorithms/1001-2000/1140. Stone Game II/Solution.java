class Solution {
    public int stoneGameII(int[] piles) {
        int length = piles.length;
        int[] rearSums = new int[length];
        rearSums[length - 1] = piles[length - 1];
        for (int i = length - 2; i >= 0; i--)
            rearSums[i] = rearSums[i + 1] + piles[i];
        int[][] dp = new int[length + 1][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j >= 0; j--) {
                int maxStones = 0;
                int startIndex = i, endIndex = Math.min(length - 1, 2 * (j + 1) + i - 1);
                for (int k = startIndex; k <= endIndex; k++) {
                    int maxTiles = Math.max(k - i + 1, j + 1);
                    maxStones = Math.max(maxStones, rearSums[i] - dp[k + 1][maxTiles - 1]);
                }
                dp[i][j] = maxStones;
            }
        }
        return dp[0][0];
    }
}