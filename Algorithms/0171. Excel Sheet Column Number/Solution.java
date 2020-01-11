class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = s.charAt(i) - 'A';
        int number = 0;
        for (int i = 0; i < length; i++) {
            number *= 26;
            number += array[i];
            number++;
        }
        return number;
    }
}