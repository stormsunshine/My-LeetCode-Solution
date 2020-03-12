class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public boolean isPrime(int num) {
        if (num == 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        int upperBound = (int) Math.sqrt(num);
        for (int i = 5; i <= upperBound; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}