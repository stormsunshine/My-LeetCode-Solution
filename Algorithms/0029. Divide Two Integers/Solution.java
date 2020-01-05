class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = 1;
        if (dividend < 0 ^ divisor < 0)
            sign = -sign;
        long dividendLong = (long) dividend;
        long divisorLong = (long) divisor;
        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);
        int maxLength = 32;
        long[] array = new long[maxLength];
        array[0] = divisorLong;
        for (int i = 1; i < maxLength; i++) {
            array[i] = array[0] << i;
            if (array[i] > dividendLong) {
                maxLength = i;
                break;
            }
        }
        long[] effectiveArray = new long[maxLength];
        for (int i = 0; i < maxLength; i++)
            effectiveArray[i] = array[i];
        int[] multiples = new int[maxLength];
        multiples[0] = 1;
        for (int i = 1; i < maxLength; i++)
            multiples[i] = multiples[0] << i;
        long remain = dividendLong;
        int quotient = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            if (remain >= effectiveArray[i]) {
                remain -= effectiveArray[i];
                quotient += multiples[i];
            }
        }
        if (sign < 0)
            quotient = -quotient;
        return quotient;
    }
}