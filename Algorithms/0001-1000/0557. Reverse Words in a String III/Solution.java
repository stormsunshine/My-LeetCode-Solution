class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverseWords(array);
        return new String(array);
    }

    public void reverseWords(char[] array) {
        reverseEachWord(array);
    }

    public void reverseEachWord(char[] array) {
        int length = array.length;
        int begin = -1, end = -1;
        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (c == ' ') {
                reverseCharacters(array, begin, end);
                begin = i + 1;
                end = i + 1;
            } else {
                if (begin < 0)
                    begin = i;
                end = i;
            }
        }
        reverseCharacters(array, begin, end);
    }

    public void reverseCharacters(char[] array, int low, int high) {
        while (low < high) {
            char c1 = array[low], c2 = array[high];
            array[low] = c2;
            array[high] = c1;
            low++;
            high--;
        }
    }
}