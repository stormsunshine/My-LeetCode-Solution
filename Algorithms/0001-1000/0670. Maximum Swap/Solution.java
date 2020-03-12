class Solution {
    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        selectionSort(array);
        String newNumStr = new String(array);
        int newNum = Integer.parseInt(newNumStr);
        return newNum;
    }

    public void selectionSort(char[] array) {
        int length = array.length;
        int lengthOuter = length - 1;
        for (int i = 0; i < lengthOuter; i++) {
            char curDigit = array[i];
            int maxIndex = length - 1;
            char maxDigit = array[length - 1];
            for (int j = length - 1; j > i; j--) {
                char digit = array[j];
                if (digit > maxDigit) {
                    maxIndex = j;
                    maxDigit = digit;
                }
            }
            if (maxDigit > curDigit) {
                array[i] = maxDigit;
                array[maxIndex] = curDigit;
                return;
            }
        }
    }
}