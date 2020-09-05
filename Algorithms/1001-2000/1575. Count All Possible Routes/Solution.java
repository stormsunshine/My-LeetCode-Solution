class Solution {
    static final int MODULO = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int length = locations.length;
        long[][] dp = new long[length][fuel + 1];
        for (int i = 0; i < length; i++)
            Arrays.fill(dp[i], -1);
        return (int) dp(dp, locations, start, finish, fuel);
    }

    public long dp(long[][] dp, int[] locations, int start, int finish, int fuel) {
        if (dp[start][fuel] == -1) {
            long count = 0;
            if (start == finish)
                count++;
            int length = locations.length;
            for (int i = 0; i < length; i++) {
                if (i != start) {
                    int remain = fuel - Math.abs(locations[start] - locations[i]);
                    if (remain >= 0)
                        count += dp(dp, locations, i, finish, remain);
                }
            }
            dp[start][fuel] = count % MODULO;
        }
        return dp[start][fuel];
    }
}