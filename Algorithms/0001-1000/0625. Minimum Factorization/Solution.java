class Solution {
    public int smallestFactorization(int a) {
        if (a < 10)
            return a;
        boolean oneDigitPrime = oneDigitPrime(a);
        if (!oneDigitPrime)
            return 0;
        List<Integer> factors = new ArrayList<Integer>();
        int num = a;
        for (int i = 9; i > 1 && num > 1; i--) {
            while (num % i == 0) {
                num /= i;
                factors.add(i);
            }
        }
        if (factors.size() > 10)
            return 0;
        long newNumLong = 0;
        for (int i = factors.size() - 1; i >= 0; i--)
            newNumLong = newNumLong * 10 + factors.get(i);
        if (newNumLong > Integer.MAX_VALUE)
            return 0;
        else
            return (int) newNumLong;
    }

    public boolean oneDigitPrime(int num) {
        while (num % 2 == 0)
            num /= 2;
        for (int i = 3; i <= 7 && num > 1; i += 2) {
            while (num % i == 0)
                num /= i;
        }
        return num == 1;
    }
}