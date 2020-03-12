class Solution {
    public int numberOfSubstrings(String s) {
        int substrings = 0;
        int[] counts = new int[3];
        int length = s.length();
        int lettersCount = 0;
        int start = 0, end = 0;
        while (end < length) {
            char c = s.charAt(end);
            counts[c - 'a']++;
            if (counts[c - 'a'] == 1)
                lettersCount++;
            while (lettersCount == 3) {
                substrings += length - end;
                char prevC = s.charAt(start);
                start++;
                counts[prevC - 'a']--;
                if (counts[prevC - 'a'] == 0)
                    lettersCount--;
            }
            end++;
        }
        return substrings;
    }
}