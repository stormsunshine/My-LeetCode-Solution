class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long i = 1; i <= n; i *= 10) {
            long unit = i * 10;
            ones += n / unit * i + Math.min(i, Math.max(0, n % unit - i + 1));
        }
        return ones;
    }
}