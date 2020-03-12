class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0)
            return false;
        int[][] primeFactorization = primeFactorize(num);
        long factorsSum = 1;
        for (int[] primePower : primeFactorization) {
            int prime = primePower[0], power = primePower[1];
            long primeSum = 0;
            long factor = 1;
            for (int i = 0; i <= power; i++) {
                primeSum += factor;
                factor *= prime;
            }
            factorsSum *= primeSum;
        }
        return factorsSum == (long) (2 * num);
    }

    public int[][] primeFactorize(int num) {
        List<Integer> primes = new ArrayList<Integer>();
        List<Integer> powers = new ArrayList<Integer>();
        if (num % 2 == 0) {
            primes.add(2);
            int power2 = 0;
            while (num % 2 == 0) {
                num /= 2;
                power2++;
            }
            powers.add(power2);
        }
        int prime = 3;
        while (num > 1) {
            if (num % prime == 0) {
                primes.add(prime);
                int power = 0;
                while (num % prime == 0) {
                    num /= prime;
                    power++;
                }
                powers.add(power);
            }
            prime += 2;
        }
        int length = primes.size();
        int[][] primeFactorization = new int[length][2];
        for (int i = 0; i < length; i++) {
            primeFactorization[i][0] = primes.get(i);
            primeFactorization[i][1] = powers.get(i);
        }
        return primeFactorization;
    }
}