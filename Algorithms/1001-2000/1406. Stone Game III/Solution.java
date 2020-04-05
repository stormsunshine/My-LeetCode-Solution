class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int length = stoneValue.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[length] = 0;
        for (int i = length - 1; i >= 0; i--) {
            int sum = 0;
            int max = Math.min(i + 2, length - 1);
            for (int j = i; j <= max; j++) {
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}