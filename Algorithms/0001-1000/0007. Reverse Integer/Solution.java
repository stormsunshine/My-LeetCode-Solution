class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        int newX = Math.abs(x);
        long xLong = 0;
        while (newX > 0) {
            xLong = xLong * 10 + newX % 10;
            newX /= 10;
        }
        xLong *= sign;
        if (xLong > Integer.MAX_VALUE || xLong < Integer.MIN_VALUE)
            return 0;
        int reverse = (int) xLong;
        return reverse;
    }
}