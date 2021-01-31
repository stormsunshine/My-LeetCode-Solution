class Solution {
    public boolean checkPartitioning(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++)
            isPalindrome[i][i] = true;
        for (int i = 1; i < length; i++)
            isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++)
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        }
        int maxFirst = length - 3, maxSecond = length - 2;
        for (int i = 0; i <= maxFirst; i++) {
            if (isPalindrome[0][i]) {
                for (int j = i + 1; j <= maxSecond; j++) {
                    if (isPalindrome[i + 1][j] && isPalindrome[j + 1][length - 1])
                        return true;
                }
            }
        }
        return false;
    }
}