class Solution {
    public int magicalString(int n) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        int digit = 1;
        while (sb.length() < n) {
            if (index >= sb.length()) {
                for (int i = 0; i < digit; i++)
                    sb.append(digit);
            } else {
                int curDigit = sb.charAt(index) - '0';
                for (int i = 0; i < curDigit; i++)
                    sb.append(digit);
            }
            digit = 3 - digit;
            index++;
        }
        String str = sb.substring(0, n).toString();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1')
                ones++;
        }
        return ones;
    }
}