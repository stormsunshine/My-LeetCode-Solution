class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        int[] count = new int[26];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char c : sArray)
            count[c - 'a']++;
        for (char c : tArray)
            count[c - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}