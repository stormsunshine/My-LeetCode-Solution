class Solution {
    public String replaceDigits(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        for (int i = 1; i < length; i += 2) {
            char letter = array[i - 1];
            int digit = array[i] - '0';
            array[i] = (char) (letter + digit);
        }
        return new String(array);
    }
}