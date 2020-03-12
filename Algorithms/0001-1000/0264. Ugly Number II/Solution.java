class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int pointer2 = 0, pointer3 = 0, pointer5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[pointer2] * 2, num3 = dp[pointer3] * 3, num5 = dp[pointer5] * 5;
            int min = Math.min(Math.min(num2, num3), num5);
            dp[i] = min;
            if (min == num2)
                pointer2++;
            if (min == num3)
                pointer3++;
            if (min == num5)
                pointer5++;
        }
        return dp[n - 1];
    }
}