class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String word : d) {
            if (isSubsequence(word, s)) {
                if (word.length() > longestWord.length() || word.length() == longestWord.length() && word.compareTo(longestWord) < 0)
                    longestWord = word;
            }
        }
        return longestWord;
    }

    public boolean isSubsequence(String word, String str) {
        int length1 = word.length(), length2 = str.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            char c1 = word.charAt(index1), c2 = str.charAt(index2);
            if (c1 == c2)
                index1++;
            index2++;
        }
        return index1 == length1;
    }
}