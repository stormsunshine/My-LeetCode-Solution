class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || searchWord == null || searchWord.length() == 0 || sentence.length() < searchWord.length())
            return -1;
        String[] array = sentence.split(" ");
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String word = array[i];
            if (word.indexOf(searchWord) == 0)
                return i + 1;
        }
        return -1;
    }
}