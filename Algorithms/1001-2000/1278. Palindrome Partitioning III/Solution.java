class Solution {
    public int palindromePartition(String s, int k) {
        int length = s.length();
        int[][] costs = new int[length][length];
        for (int i = 1; i < length; i++) {
            if (s.charAt(i - 1) != s.charAt(i))
                costs[i - 1][i] = 1;
        }
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                costs[i][j] = costs[i + 1][j - 1];
                if (s.charAt(i) != s.charAt(j))
                    costs[i][j]++;
            }
        }
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= k; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            int max = Math.min(i, k);
            for (int j = 1; j <= max; j++) {
                if (j == 1)
                    dp[i][j] = costs[0][i - 1];
                else {
                    for (int start = j - 1; start < i; start++)
                        dp[i][j] = Math.min(dp[i][j], dp[start][j - 1] + costs[start][i - 1]);
                }
            }
        }
        return dp[length][k];
    }
}