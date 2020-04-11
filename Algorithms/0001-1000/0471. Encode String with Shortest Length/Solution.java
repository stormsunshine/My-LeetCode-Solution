class Solution {
    public String encode(String s) {
        int length = s.length();
        String[][] dp = new String[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                int curLength = j - i + 1;
                String substring = s.substring(i, j + 1);
                if (curLength <= 4)
                    dp[i][j] = substring;
                else {
                    int subLength = (substring + substring).indexOf(substring, 1);
                    if (subLength < curLength)
                        dp[i][j] = String.valueOf(curLength / subLength) + "[" + dp[i][i + subLength - 1] + "]";
                    else {
                        dp[i][j] = substring;
                        for (int k = i; k < j; k++) {
                            if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length())
                                dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }
            }
        }
        return dp[0][length - 1];
    }
}