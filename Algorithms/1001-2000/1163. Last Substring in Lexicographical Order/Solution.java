class Solution {
    public String lastSubstring(String s) {
        char maxChar = 'a';
        int length = s.length();
        int index = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c > maxChar) {
                index = i;
                maxChar = c;
            } else if (c == maxChar) {
                if (i > 0 && c == s.charAt(i - 1))
                    continue;
                int temp = index;
                index = i;
                for (int j = i, k = temp; j < length && k < length; j++, k++) {
                    if (s.charAt(j) < s.charAt(k)) {
                        index = temp;
                        break;
                    } else if (s.charAt(j) > s.charAt(k))
                        break;
                }
            }
        }
        return s.substring(index);
    }
}