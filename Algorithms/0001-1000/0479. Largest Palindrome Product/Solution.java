class Solution {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;
        long max = (long) Math.pow(10, n) - 1;
        long start = max - 1, end = max / 10 + 1;
        for (long i = max - 1; i >= end; i--) {
            String str = String.valueOf(i);
            StringBuffer sb = new StringBuffer(str).reverse();
            long palindrome = Long.parseLong(str + sb.toString());
            long min = (long) Math.ceil(Math.sqrt(palindrome));
            for (long j = max; j >= min; j--) {
                if (palindrome % j == 0)
                    return (int) (palindrome % 1337);
            }
        }
        return -1;
    }
}