class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        int length1 = S.length(), length2 = T.length();
        for (int i = 0; i < length1; i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (sb1.length() > 0)
                    sb1.deleteCharAt(sb1.length() - 1);
            } else
                sb1.append(c);
        }
        for (int i = 0; i < length2; i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (sb2.length() > 0)
                    sb2.deleteCharAt(sb2.length() - 1);
            } else
                sb2.append(c);
        }
        return sb1.toString().equals(sb2.toString());
    }
}