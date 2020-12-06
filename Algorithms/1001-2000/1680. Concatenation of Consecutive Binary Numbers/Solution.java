class Solution {
    public int concatenatedBinary(int n) {
        final int MODULO = 1000000007;
        long num = 0;
        int bits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                bits++;
            num = ((num << bits) + i) % MODULO;
        }
        return (int) num;
    }
}