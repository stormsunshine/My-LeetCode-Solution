class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (String word : words) {
            if (canFormWord(word, chars))
                sum += word.length();
        }
        return sum;
    }

    public boolean canFormWord(String word, String chars) {
        int[] wordCount = new int[26];
        int[] charsCount = new int[26];
        char[] wordArray = word.toCharArray();
        for (char c : wordArray)
            wordCount[c - 'a']++;
        char[] charsArray = chars.toCharArray();
        for (char c : charsArray)
            charsCount[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charsCount[i])
                return false;
        }
        return true;
    }
}