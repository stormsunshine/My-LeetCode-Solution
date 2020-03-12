class Solution {
    public boolean confusingNumber(int N) {
        String num = String.valueOf(N);
        int length = num.length();
        StringBuffer sb = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c != '0' && c != '1' && c != '8' && c != '6' && c != '9')
                return false;
            sb.append(rotate(c));
        }
        String rotate = sb.toString();
        return !num.equals(rotate);
    }

    public char rotate(char c) {
        if (c == '6' || c == '9')
            return (char) ('6' + '9' - c);
        else
            return c;
    }
}