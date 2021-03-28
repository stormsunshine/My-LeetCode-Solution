class Solution {
    static final int MODULO = 1000000007;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3)
            return primeFactors;
        int quotient = primeFactors / 3;
        int remainder = primeFactors % 3;
        if (remainder == 0)
            return (int) (pow(3, quotient) % MODULO);
        else if (remainder == 1)
            return (int) (pow(3, quotient - 1) * 4 % MODULO);
        else
            return (int) (pow(3, quotient) * 2 % MODULO);
    }

    public long pow(long x, int n) {
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