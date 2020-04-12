class Solution {
    public int numOfWays(int n) {
        final int MODULO = 1000000007;
        long prev2 = 6, prev3 = 6;
        for (int i = 2; i <= n; i++) {
            long curr2 = (prev2 * 3 + prev3 * 2) % MODULO;
            long curr3 = (prev2 * 2 + prev3 * 2) % MODULO;
            prev2 = curr2;
            prev3 = curr3;
        }
        int ways = (int) ((prev2 + prev3) % MODULO);
        return ways;
    }
}