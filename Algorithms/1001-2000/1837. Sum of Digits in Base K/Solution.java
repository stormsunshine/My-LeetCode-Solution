class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % k;
            sum += remainder;
            n /= k;
        }
        return sum;
    }
}