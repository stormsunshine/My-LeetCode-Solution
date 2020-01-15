class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int[] update : updates) {
            int startIndex = update[0], endIndex = update[1], inc = update[2];
            array[startIndex] += inc;
            if (endIndex < length - 1)
                array[endIndex + 1] -= inc;
        }
        for (int i = 1; i < length; i++)
            array[i] += array[i - 1];
        return array;
    }
}