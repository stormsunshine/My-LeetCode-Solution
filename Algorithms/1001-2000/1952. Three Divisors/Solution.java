class Solution {
    public boolean isThree(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n)
            return false;
        int divisors = 1;
        for (int i = 1; i < sqrt; i++) {
            if (n % i == 0)
                divisors += 2;
        }
        return divisors == 3;
    }
}