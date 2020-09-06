class Solution {
    public String modifyString(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        if (array[0] == '?') {
            if (length == 1)
                array[0] = 'a';
            else {
                if (array[1] == 'a')
                    array[0] = 'b';
                else
                    array[0] = 'a';
            }
        }
        if (array[length - 1] == '?') {
            if (array[length - 2] == 'a')
                array[length - 1] = 'b';
            else
                array[length - 1] = 'a';
        }
        for (int i = 1; i < length - 1; i++) {
            char curr = array[i];
            if (curr == '?') {
                char prev = array[i - 1], next = array[i + 1];
                char letter = 'a';
                while (letter == prev || letter == next)
                    letter++;
                array[i] = letter;
            }
        }
        return new String(array);
    }
}