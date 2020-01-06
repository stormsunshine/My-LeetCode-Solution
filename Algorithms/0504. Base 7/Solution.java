class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        int sign = num >= 0 ? 1 : -1;
        num = Math.abs(num);
        StringBuffer base7 = new StringBuffer();
        while (num > 0) {
            int remainder = num % 7;
            base7.insert(0, (char) (remainder + '0'));
            num /= 7;
        }
        if (sign < 0)
            base7.insert(0, '-');
        return base7.toString();
    }
}