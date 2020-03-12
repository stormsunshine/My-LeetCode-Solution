class Solution {
    public int trailingZeroes(int n) {
        int zeroes = 0;
        int fives = 5;
        while (fives <= n) {
            zeroes += n / fives;
            n /= 5;
        }
        return zeroes;
    }
}