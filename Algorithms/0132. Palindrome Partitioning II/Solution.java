class Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++)
            isPalindrome[i][i] = true;
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                isPalindrome[i][i + 1] = true;
        }
        for (int i = 1; i < length - 1; i++) {
            int upperBound = Math.min(i, length - i - 1);
            for (int j = 1; j <= upperBound; j++) {
                if (s.charAt(i - j) == s.charAt(i + j) && isPalindrome[i - j + 1][i + j - 1])
                    isPalindrome[i - j][i + j] = true;
            }
        }
        for (int i = 1; i < length - 2; i++) {
            int upperBound = Math.min(i, length - i - 2);
            for (int j = 1; j <= upperBound; j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j) && isPalindrome[i - j + 1][i + j])
                    isPalindrome[i - j][i + j + 1] = true;
            }
        }
        int[] dp = new int[length];
        for (int i = 1; i < length; i++)
            dp[i] = i;
        for (int i = 1; i < length; i++) {
            if (isPalindrome[0][i])
                dp[i] = 0;
            else {
                for (int j = i; j > 0; j--) {
                    if (isPalindrome[j][i])
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}