class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        final int MODULO = 1000000007;
        int length = s.length();
        long[] dp = new long[length + 1];
        dp[length] = 1;
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : s.charAt(length - 1) == '*' ? 9 : 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                dp[i] = 0;
            else {
                char c1 = s.charAt(i), c2 = s.charAt(i + 1);
                if (c1 == '*' && c2 == '*') {
                    int twos = 0;
                    for (int j = 1; j <= 9; j++) {
                        for (int k = 1; k <= 9; k++) {
                            int num = j * 10 + k;
                            if (num <= 26)
                                twos++;
                        }
                    }
                    dp[i] = 9 * dp[i + 1] + twos * dp[i + 2];
                } else if (c1 == '*') {
                    int twos = 0;
                    for (int num = 10 + c2 - '0'; num < 100; num += 10) {
                        if (num <= 26)
                            twos++;
                    }
                    dp[i] = 9 * dp[i + 1] + twos * dp[i + 2];
                } else if (c2 == '*') {
                    int twos = 0;
                    int low = (c1 - '0') * 10 + 1, high = (c1 - '0') * 10 + 9;
                    for (int num = low; num <= high; num++) {
                        if (num <= 26)
                            twos++;
                    }
                    dp[i] = dp[i + 1] + twos * dp[i + 2];
                } else {
                    int num = Integer.parseInt(s.substring(i, i + 2));
                    dp[i] = num <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
                }
            }
            dp[i] %= MODULO;
        }
        return (int) dp[0];
    }
}