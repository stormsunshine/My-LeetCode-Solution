class Solution {
    public String makeFancyString(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        char prev = ' ';
        int count = 1;
        for (int i = 0; i < length; i++) {
            char curr = s.charAt(i);
            if (curr == prev)
                count++;
            else {
                count = 1;
                prev = curr;
            }
            if (count < 3)
                sb.append(curr);
        }
        return sb.toString();
    }
}