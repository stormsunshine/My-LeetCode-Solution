class Solution {
    public String getPermutation(int n, int k) {
        char[] array = new char[n];
        for (int i = 1; i <= n; i++)
            array[i - 1] = (char) ('0' + i);
        for (int i = 1; i < k; i++)
            nextPermutation(array);
        return new String(array);
    }

    public void nextPermutation(char[] array) {
        int length = array.length;
        int index = -1;
        char curNum = (char) ('0' - 1);
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curNum = array[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return;
        }
        int nextIndex = -1;
        char nextNum = (char) ('9' + 1);
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curNum && array[i] < nextNum) {
                nextIndex = i;
                nextNum = array[i];
            }
        }
        array[index] = nextNum;
        array[nextIndex] = curNum;
        Arrays.sort(array, index + 1, length);
    }
}