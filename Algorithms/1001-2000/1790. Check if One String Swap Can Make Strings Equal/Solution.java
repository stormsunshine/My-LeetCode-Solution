class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int length = s1.length();
        int different = 0;
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2)
                different++;
            count1[c1 - 'a']++;
            count2[c2 - 'a']++;
        }
        if (different != 2)
            return false;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }
}