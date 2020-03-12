class Solution {
    public int numPrimeArrangements(int n) {
        final int MODULO = 1000000007;
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                primeCount++;
        }
        int notPrimeCount = n - primeCount;
        long arrangements = 1L;
        for (long i = 1L; i <= primeCount; i++)
            arrangements = (arrangements * i) % MODULO;
        for (long i = 1L; i <= notPrimeCount; i++)
            arrangements = (arrangements * i) % MODULO;
        return (int) arrangements;
    }

    public boolean isPrime(int num) {
        if (num == 1)
            return false;
        if (num == 2 || num == 3 || num == 5 || num == 7)
            return true;
        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0)
            return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 11; i <= sqrt; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}