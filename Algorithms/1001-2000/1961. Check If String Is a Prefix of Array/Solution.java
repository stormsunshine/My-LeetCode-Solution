class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int length = s.length();
        int arrLength = words.length;
        int index = 0;
        for (int i = 0; i < arrLength && index < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            int j = 0;
            while (j < wordLength && index < length) {
                if (s.charAt(index) == word.charAt(j)) {
                    index++;
                    j++;
                } else
                    return false;
            }
            if (index == length && j < wordLength)
                return false;
        }
        return index == length;
    }
}