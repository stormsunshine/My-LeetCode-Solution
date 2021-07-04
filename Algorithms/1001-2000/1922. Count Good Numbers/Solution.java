class Solution {
    static final int MODULO = 1000000007;

    public int countGoodNumbers(long n) {
        long halfN = n / 2;
        int remainder = (int) (n % 2);
        long count = myPow(5 * 4, halfN);
        if (remainder == 1)
            count *= 5;
        count %= MODULO;
        return (int) count;
    }

    public long myPow(long x, long n) {
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