class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLength = 0;
        int length = word.length();
        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (c == 'a') {
                if (i > 0 && c == word.charAt(i - 1))
                    continue;
                else {
                    sb.append(c);
                    list.add(i);
                }
            } else {
                if (i < length - 1 && c == word.charAt(i + 1))
                    continue;
                else {
                    sb.append(c);
                    list.add(i);
                }
            }
        }
        int newLength = sb.length();
        for (int i = 4; i < newLength; i++) {
            if (sb.charAt(i - 4) == 'a' && sb.charAt(i - 3) == 'e' && sb.charAt(i - 2) == 'i' && sb.charAt(i - 1) == 'o' && sb.charAt(i) == 'u') {
                int start = list.get(i - 4), end = list.get(i);
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        return maxLength;
    }
}