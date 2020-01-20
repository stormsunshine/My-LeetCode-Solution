class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        int steps = 0;
        List<Integer> primes = primeFactorization(n);
        for (int prime : primes)
            steps += prime;
        return steps;
    }

    public List<Integer> primeFactorization(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        if (n == 1)
            return primes;
        int upperBound = (int) Math.sqrt(n);
        int temp = n;
        while (temp % 2 == 0) {
            primes.add(2);
            temp /= 2;
        }
        for (int i = 3; i <= upperBound; i += 2) {
            while (temp % i == 0) {
                primes.add(i);
                temp /= i;
            }
        }
        if (temp > 1)
            primes.add(temp);
        return primes;
    }
}