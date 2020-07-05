class Solution {
    public String minInteger(String num, int k) {
        char[] array = num.toCharArray();
        int length = array.length;
        int index = 0;
        while (k > 0 && index < length) {
            int minDigit = array[index] - '0', minIndex = index;
            int upperBound = Math.min(length - 1, index + k);
            for (int i = index + 1; i <= upperBound; i++) {
                int digit = array[i] - '0';
                if (digit < minDigit) {
                    minDigit = digit;
                    minIndex = i;
                }
            }
            k -= (minIndex - index);
            char c = array[minIndex];
            for (int i = minIndex - 1; i >= index; i--)
                array[i + 1] = array[i];
            array[index] = c;
            index++;
        }
        return new String(array);
    }
}