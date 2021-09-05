class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        final int MODULO = 1000000007;
        int length = nextVisit.length;
        int[] dp = new int[length];
        for (int i = 1; i < length; i++)
            dp[i] = ((dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2) % MODULO + MODULO) % MODULO;
        return dp[length - 1];
    }
}