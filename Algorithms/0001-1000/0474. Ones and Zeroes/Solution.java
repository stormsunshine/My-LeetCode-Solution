class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            String str = strs[i - 1];
            int[] zerosOnes = countZerosOnes(str);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zeros || k < ones)
                        dp[i][j][k] = dp[i - 1][j][k];
                    else
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] countZerosOnes(String str) {
        int[] count = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            count[c - '0']++;
        }
        return count;
    }
}