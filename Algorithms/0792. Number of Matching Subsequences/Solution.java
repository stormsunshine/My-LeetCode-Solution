class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, S))
                count++;
        }
        return count;
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