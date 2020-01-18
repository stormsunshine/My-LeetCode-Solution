class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;
        if (s2.indexOf(s1) >= 0)
            return true;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        int length1 = s1.length(), length2 = s2.length();
        for (int i = 0; i < length1; i++) {
            char c1 = s1.charAt(i);
            counts1[c1 - 'a']++;
            char c2 = s2.charAt(i);
            counts2[c2 - 'a']++;
        }
        if (checkSubstring(counts1, counts2))
            return true;
        for (int i = length1; i < length2; i++) {
            char prevC = s2.charAt(i - length1), curC = s2.charAt(i);
            counts2[prevC - 'a']--;
            counts2[curC - 'a']++;
            if (checkSubstring(counts1, counts2))
                return true;
        }
        return false;
    }

    public boolean checkSubstring(int[] counts1, int[] counts2) {
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i])
                return false;
        }
        return true;
    }
}