class Solution {
    public int numTilings(int N) {
        if (N == 0)
            return 1;
        if (N <= 2)
            return N;
        final int MODULO = 1000000007;
        int prev2 = 1, prev1 = 1, cur = 2;
        for (int i = 3; i <= N; i++) {
            int next = (cur * 2 % MODULO + prev2) % MODULO;
            prev2 = prev1;
            prev1 = cur;
            cur = next;
        }
        return cur;
    }
}