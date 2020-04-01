class Solution {
    public int distinctSubseqII(String S) {
        final int MODULO = 1000000007;
        int length = S.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < length; i++) {
            int index = S.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % MODULO;
            if (last[index] >= 0)
                dp[i + 1] -= dp[last[index]];
            dp[i + 1] = (dp[i + 1] + MODULO) % MODULO;
            last[index] = i;
        }
        int distinctSubsequences = (dp[length] - 1 + MODULO) % MODULO;
        return distinctSubsequences;
    }
}