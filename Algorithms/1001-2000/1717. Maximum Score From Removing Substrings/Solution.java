class Solution {
    int points = 0;

    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            s = remove1(s, x);
            s = remove2(s, y);
        } else {
            s = remove2(s, y);
            s = remove1(s, x);
        }
        return points;
    }

    public String remove1(String s, int x) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (index > 0 && c == 'b' && sb.charAt(index - 1) == 'a') {
                points += x;
                sb.deleteCharAt(index - 1);
                index--;
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }

    public String remove2(String s, int y) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (index > 0 && c == 'a' && sb.charAt(index - 1) == 'b') {
                points += y;
                sb.deleteCharAt(index - 1);
                index--;
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
}