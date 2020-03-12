class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        Set<Character> skipSet = new HashSet<Character>();
        for (char c = 'a'; c <= 'z'; c++) {
            int count = counts[c - 'a'];
            if (count > 0 && count < k)
                skipSet.add(c);
        }
        if (skipSet.size() == 0)
            return length;
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (skipSet.contains(c)) {
                maxLength = Math.max(maxLength, longestSubstring(s.substring(startIndex, i), k));
                startIndex = i + 1;
            }
        }
        maxLength = Math.max(maxLength, longestSubstring(s.substring(startIndex), k));
        return maxLength;
    }
}