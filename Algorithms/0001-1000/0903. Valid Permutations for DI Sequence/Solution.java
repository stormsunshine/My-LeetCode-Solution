class Solution {
    public int numPermsDISequence(String S) {
        final int MODULO = 1000000007;
        int length = S.length();
        int[][] dp = new int[length + 1][length + 2];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            if (S.charAt(i - 1) == 'D') {
                for (int j = i - 1; j >= 0; j--)
                    dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % MODULO;
            } else {
                for (int j = 1; j <= i; j++)
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % MODULO;
            }
        }
        int permutations = 0;
        for (int i = 0; i <= length + 1; i++)
            permutations = (permutations + dp[length][i]) % MODULO;
        return permutations;
    }
}