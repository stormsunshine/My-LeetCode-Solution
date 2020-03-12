class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String longestWord = "";
        int maxLength = 0;
        Set<String> set = new HashSet<String>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            if (wordLength == 1 || set.contains(word.substring(0, wordLength - 1))) {
                if (wordLength > maxLength || wordLength == maxLength && word.compareTo(longestWord) < 0) {
                    longestWord = word;
                    maxLength = wordLength;
                }
                set.add(word);
            }
        }
        return longestWord;
    }
}