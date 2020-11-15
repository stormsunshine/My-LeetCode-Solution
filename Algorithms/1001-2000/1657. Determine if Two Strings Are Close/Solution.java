class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        int length = word1.length();
        for (int i = 0; i < length; i++) {
            char c1 = word1.charAt(i), c2 = word2.charAt(i);
            counts1[c1 - 'a']++;
            counts2[c2 - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts1[i] == 0 ^ counts2[i] == 0)
                return false;
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        return Arrays.equals(counts1, counts2);
    }
}