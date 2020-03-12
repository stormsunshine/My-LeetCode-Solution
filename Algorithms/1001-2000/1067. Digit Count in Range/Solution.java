class Solution {
    public int digitsCount(int d, int low, int high) {
        long highCount = countDigits(high, d);
        long lowCount = countDigits(low - 1, d);
        int count = (int) (highCount - lowCount);
        return count;
    }

    public long countDigits(int n, int digit) {
        if (n <= 0)
            return 0;
        long count = 0;
        if (digit == 0) {
            for (long i = 1; i <= n / 10; i *= 10) {
                long unit = i * 10;
                count += (n / unit - 1) * i + Math.min(i, Math.max(0, n % unit - digit * i + 1));
            }
        } else {
            for (long i = 1; i <= n; i *= 10) {
                long unit = i * 10;
                count += n / unit * i + Math.min(i, Math.max(0, n % unit - digit * i + 1));
            }
        }
        return count;
    }
}