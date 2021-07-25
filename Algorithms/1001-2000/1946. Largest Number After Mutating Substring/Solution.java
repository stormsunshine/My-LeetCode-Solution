class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] array = num.toCharArray();
        int length = array.length;
        int start = -1, end = length;
        for (int i = 0; i < length; i++) {
            int digit = array[i] - '0';
            if (digit < change[digit]) {
                start = i;
                break;
            }
        }
        if (start < 0)
            return num;
        for (int i = start + 1; i < length; i++) {
            int digit = array[i] - '0';
            if (digit > change[digit]) {
                end = i;
                break;
            }
        }
        for (int i = start; i < end; i++) {
            int digit = array[i] - '0';
            char changed = (char) ('0' + change[digit]);
            array[i] = changed;
        }
        return new String(array);
    }
}