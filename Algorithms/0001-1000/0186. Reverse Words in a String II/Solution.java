class Solution {
    public void reverseWords(char[] s) {
        reverseEachWord(s);
        reverseCharacters(s);
    }

    public void reverseEachWord(char[] s) {
        int length = s.length;
        int begin = -1, end = -1;
        for (int i = 0; i < length; i++) {
            char c = s[i];
            if (c == ' ') {
                reverseCharacters(s, begin, end);
                begin = i + 1;
                end = i + 1;
            } else {
                if (begin < 0)
                    begin = i;
                end = i;
            }
        }
        reverseCharacters(s, begin, end);
    }

    public void reverseCharacters(char[] s) {
        reverseCharacters(s, 0, s.length - 1);
    }

    public void reverseCharacters(char[] s, int low, int high) {
        while (low < high) {
            char c1 = s[low], c2 = s[high];
            s[low] = c2;
            s[high] = c1;
            low++;
            high--;
        }
    }
}