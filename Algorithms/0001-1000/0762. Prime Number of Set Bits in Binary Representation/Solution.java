class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            int ones = Integer.bitCount(i);
            if (isPrime(ones))
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
        int upper = (int) Math.sqrt(num);
        for (int i = 5; i <= upper; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}