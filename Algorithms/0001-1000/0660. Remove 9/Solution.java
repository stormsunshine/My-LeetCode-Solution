public class Solution {
    public int newInteger(int n) {
        String radix9Str = "";
        while (n > 0) {
            int remainder = n % 9;
            radix9Str = remainder + radix9Str;
            n /= 9;
        }
        int radix9 = Integer.parseInt(radix9Str);
        return radix9;
    }
}