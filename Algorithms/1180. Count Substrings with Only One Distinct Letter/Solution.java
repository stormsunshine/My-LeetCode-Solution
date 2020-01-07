class Solution {
    public int countLetters(String S) {
        int count = 0;
        int length = S.length();
        int consecutive = 0;
        char prevChar = '0';
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == prevChar)
                consecutive++;
            else {
                count += consecutive * (consecutive + 1) / 2;
                consecutive = 1;
            }
            prevChar = c;
        }
        if (consecutive > 0)
            count += consecutive * (consecutive + 1) / 2;
        return count;
    }
}