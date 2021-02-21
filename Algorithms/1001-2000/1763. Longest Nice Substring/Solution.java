class Solution {
    public String longestNiceSubstring(String s) {
        int maxLength = 0;
        String longest = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substr = s.substring(i, j);
                if (isNice(substr)) {
                    if (substr.length() > maxLength) {
                        maxLength = substr.length();
                        longest = substr;
                    }
                }
            }
        }
        return longest;
    }

    public boolean isNice(String s) {
        Set<Character> set = new HashSet<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++)
            set.add(s.charAt(i));
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            char difCase = c <= 'Z' ? (char) (c + 'a' - 'A') : (char) (c - 'a' + 'A');
            if (!set.contains(difCase))
                return false;
        }
        return true;
    }
}