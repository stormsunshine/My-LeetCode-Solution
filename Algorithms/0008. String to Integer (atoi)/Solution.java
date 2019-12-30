class Solution {
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.length() == 0)
            return 0;
        double numDouble = 0;
        char c0 = str.charAt(0);
        if (Character.isDigit(c0))
            numDouble = c0 - '0';
        else if (c0 != '+' && c0 != '-')
            return 0;
        int sign = c0 == '-' ? -1 : 1;
        int length = str.length();
        for (int i = 1; i < length; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            int curDigit = c - '0';
            numDouble = numDouble * 10 + curDigit;
        }
        numDouble *= sign;
        if (numDouble >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (numDouble <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int num = (int) numDouble;
        return num;
    }
}