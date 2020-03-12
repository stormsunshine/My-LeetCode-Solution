class Solution {
    public int nextGreaterElement(int n) {
        char[] array = String.valueOf(n).toCharArray();
        boolean next = nextPermutation(array);
        if (!next)
            return -1;
        String nextGreaterElementStr = new String(array);
        long nextGreaterElementLong = Long.parseLong(nextGreaterElementStr);
        if (nextGreaterElementLong > Integer.MAX_VALUE)
            return -1;
        else {
            int nextGreaterElement = (int) nextGreaterElementLong;
            return nextGreaterElement;
        }
    }

    public boolean nextPermutation(char[] array) {
        int length = array.length;
        int index = -1;
        char curChar = Character.MAX_VALUE;
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curChar = array[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return false;
        }
        int nextIndex = -1;
        char nextChar = Character.MAX_VALUE;
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curChar && array[i] < nextChar) {
                nextIndex = i;
                nextChar = array[i];
            }
        }
        array[index] = nextChar;
        array[nextIndex] = curChar;
        Arrays.sort(array, index + 1, length);
        return true;
    }
}