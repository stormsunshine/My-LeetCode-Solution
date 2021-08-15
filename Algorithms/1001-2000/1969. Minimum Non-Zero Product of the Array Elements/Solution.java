class Solution {
    static final long MODULO = 1000000007;

    public int minNonZeroProduct(int p) {
        long maxNum = (1L << p) - 1;
        long remain = maxNum - 1;
        long pairs = remain / 2;
        long minProduct = quickMul(remain, pairs) * (maxNum % MODULO) % MODULO;
        return (int) (minProduct % MODULO);
    }

    public long quickMul(long x, long n) {
        x %= MODULO;
        long power = 1;
        while (n > 0) {
            if (n % 2 == 1)
                power = power * x % MODULO;
            x = x * x % MODULO;
            n /= 2;
        }
        return power;
    }
}