class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int length = jobs.length;
        int[][] dp = new int[k + 1][1 << length];
        for (int i = 0; i <= k; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        int[] times = new int[1 << length];
        for (int mask = 0; mask < 1 << length; mask++) {
            int time = 0;
            for (int i = 0; i < length; i++) {
                if ((mask & (1 << i)) != 0)
                    time += jobs[i];
            }
            times[mask] = time;
        }
        dp[k][(1 << length) - 1] = 0;
        for (int i = k - 1; i >= 0; i--) {
            for (int mask = (1 << length) - 2; mask >= 0; mask--) {
                for (int curr = 1; curr < 1 << length; curr++) {
                    if ((curr & mask) == 0) {
                        int time = Math.max(times[curr], dp[i + 1][curr | mask]);
                        dp[i][mask] = Math.min(dp[i][mask], time);
                    }
                }
            }
        }
        return dp[0][0];
    }
}