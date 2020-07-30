class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int length = s.length();
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i <= length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE >> 1);
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            int max = Math.min(i, k);
            for (int j = 0; j <= max; j++) {
                if (j > 0)
                    dp[i][j] = dp[i - 1][j - 1];
                int same = 0, different = 0;
                for (int m = i; m >= 1 && different <= j; m--) {
                    if (s.charAt(m - 1) == s.charAt(i - 1)) {
                        same++;
                        dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - different] + calculateLength(same));
                    } else
                        different++;
                }
            }
        }
        return dp[length][k];
    }

    public int calculateLength(int x) {
        if (x == 1)
            return 1;
        else if (x < 10)
            return 2;
        else if (x < 100)
            return 3;
        else
            return 4;
    }
}