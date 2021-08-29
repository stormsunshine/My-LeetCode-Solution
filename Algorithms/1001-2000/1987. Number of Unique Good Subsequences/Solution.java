class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final int MODULO = 1000000007;
        int length = binary.length();
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '0') {
                zeroCount = 1;
                break;
            }
        }
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '1') {
                startIndex = i;
                break;
            }
        }
        if (startIndex < 0)
            return 1;
        int[] dp = new int[length + 1];
        dp[startIndex + 1] = 1;
        int[] last = new int[2];
        Arrays.fill(last, -1);
        for (int i = startIndex + 1; i < length; i++) {
            int index = binary.charAt(i) - '0';
            dp[i + 1] = dp[i] * 2 % MODULO;
            if (last[index] >= 0)
                dp[i + 1] = (dp[i + 1] - dp[last[index]]) % MODULO;
            dp[i + 1] = (dp[i + 1] + MODULO) % MODULO;
            last[index] = i;
        }
        int distinctSubsequences = (dp[length] + zeroCount) % MODULO;
        return distinctSubsequences;
    }
}