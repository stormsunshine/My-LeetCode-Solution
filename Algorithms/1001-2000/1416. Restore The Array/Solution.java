class Solution {
    public int numberOfArrays(String s, int k) {
        final int MODULO = 1000000007;
        int length = s.length();
        int kLength = String.valueOf(k).length();
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if (i < kLength && Long.parseLong(s.substring(0, i + 1)) <= (long) k)
                dp[i]++;
            int min = Math.max(0, i - kLength);
            for (int j = min; j < i; j++) {
                if (s.charAt(j + 1) == '0')
                    continue;
                long curNum = Long.parseLong(s.substring(j + 1, i + 1));
                if (curNum <= (long) k)
                    dp[i] = (dp[i] + dp[j]) % MODULO;
            }
        }
        return dp[length - 1];
    }
}