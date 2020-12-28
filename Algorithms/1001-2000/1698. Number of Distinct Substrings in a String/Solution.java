class Solution {
    public int countDistinct(String s) {
        int length = s.length();
        int[] dp = new int[length];
        boolean[] exists = new boolean[26];
        dp[0] = 1;
        exists[s.charAt(0) - 'a'] = true;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (!exists[index]) {
                dp[i] = dp[i - 1] + i + 1;
                exists[index] = true;
            } else {
                int diffIndex = -1;
                for (int j = i; j >= 0; j--) {
                    String prefix = s.substring(0, i);
                    if (prefix.indexOf(s.substring(j, i + 1)) < 0) {
                        diffIndex = j + 1;
                        break;
                    }
                }
                dp[i] = dp[i - 1] + diffIndex;
            }
        }
        return dp[length - 1];
    }
}