class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substr = s.substring(i, j);
                count += countStrings(substr, t);
            }
        }
        return count;
    }

    public int countStrings(String s, String t) {
        int count = 0;
        int length = s.length();
        int maxStart = t.length() - length;
        for (int i = 0; i <= maxStart; i++) {
            if (differByOne(s, t.substring(i, i + length)))
                count++;
        }
        return count;
    }

    public boolean differByOne(String s, String t) {
        if (s.length() != t.length() || s.equals(t))
            return false;
        int differ = 0;
        int length = s.length();
        for (int i = 0; i < length && differ <= 1; i++) {
            if (s.charAt(i) != t.charAt(i))
                differ++;
        }
        return differ == 1;
    }
}