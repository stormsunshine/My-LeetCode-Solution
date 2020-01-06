class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null)
            return false;
        int length = word.length();
        if (length <= 1)
            return true;
        char c0 = word.charAt(0);
        boolean firstCapital = isCapital(c0);
        if (firstCapital) {
            char prevC = word.charAt(1);
            for (int i = 2; i < length; i++) {
                char curC = word.charAt(i);
                if (isCapital(prevC) ^ isCapital(curC))
                    return false;
                prevC = curC;
            }
            return true;
        } else {
            for (int i = 1; i < length; i++) {
                char c = word.charAt(i);
                if (isCapital(c))
                    return false;
            }
            return true;
        }
    }

    public boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
}