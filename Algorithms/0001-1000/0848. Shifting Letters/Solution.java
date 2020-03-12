class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int length = shifts.length;
        shifts[length - 1] %= 26;
        for (int i = length - 2; i >= 0; i--)
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        char[] array = S.toCharArray();
        for (int i = 0; i < length; i++) {
            int num = array[i] - 'a';
            num = (num + shifts[i]) % 26;
            array[i] = (char) (num + 'a');
        }
        return new String(array);
    }
}