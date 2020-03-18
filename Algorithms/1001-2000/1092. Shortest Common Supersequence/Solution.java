class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int longestCommonSubsequenceLength = dp[length1][length2];
        StringBuffer sb = new StringBuffer();
        int index1 = length1, index2 = length2;
        while (index1 > 0 && index2 > 0) {
            char c1 = str1.charAt(index1 - 1), c2 = str2.charAt(index2 - 1);
            if (c1 == c2) {
                sb.append(c1);
                longestCommonSubsequenceLength--;
                index1--;
                index2--;
            } else if (dp[index1 - 1][index2] == longestCommonSubsequenceLength) {
                sb.append(c1);
                index1--;
            } else {
                sb.append(c2);
                index2--;
            }
        }
        while (index1 > 0) {
            sb.append(str1.charAt(index1 - 1));
            index1--;
        }
        while (index2 > 0) {
            sb.append(str2.charAt(index2 - 1));
            index2--;
        }
        return sb.reverse().toString();
    }
}