class Solution {
    public int findNthDigit(int n) {
        if (n <= 9)
            return n;
        long digitLength = 1L, count = 9L;
        long nLong = (long) n;
        while (nLong - digitLength * count >= 0) {
            nLong -= digitLength * count;
            digitLength++;
            count *= 10;
        }
        if (nLong == 0)
            return 9;
        nLong--;
        long start = (long) Math.pow(10, digitLength - 1);
        long num = start + nLong / digitLength;
        int digitIndex = (int) (nLong % digitLength);
        char digitChar = String.valueOf(num).charAt(digitIndex);
        int digit = digitChar - '0';
        return digit;
    }
}