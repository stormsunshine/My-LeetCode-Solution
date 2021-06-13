class Solution {
    public boolean makeEqual(String[] words) {
        int[] counts = new int[26];
        for (String word : words) {
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                char c = word.charAt(i);
                counts[c - 'a']++;
            }
        }
        int length = words.length;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % length != 0)
                return false;
        }
        return true;
    }
}