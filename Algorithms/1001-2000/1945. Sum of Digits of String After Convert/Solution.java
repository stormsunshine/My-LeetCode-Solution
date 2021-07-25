class Solution {
    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int num = c - 'a' + 1;
            sb.append(num);
        }
        int sum = 0;
        int digitLength = sb.length();
        for (int i = 0; i < digitLength; i++) {
            int digit = sb.charAt(i) - '0';
            sum += digit;
        }
        for (int i = 2; i <= k; i++)
            sum = convert(sum);
        return sum;
    }

    public int convert(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}