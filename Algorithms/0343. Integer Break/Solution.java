class Solution {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 1) {
            quotient--;
            remainder += 3;
        }
        int product = (int) Math.pow(3, quotient);
        if (remainder != 0)
            product *= remainder;
        return product;
    }
}