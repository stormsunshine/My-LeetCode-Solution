public class Solution {
    public int integerReplacement(int n) {
        long longN = (long) n;
        return integerReplacement(longN);
    }

    public int integerReplacement(long n) {
        if (n == 1)
            return 0;
        else if (n % 2 == 0)
            return integerReplacement(n / 2) + 1;
        else
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
    }
}