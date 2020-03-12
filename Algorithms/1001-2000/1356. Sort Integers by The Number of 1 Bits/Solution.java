class Solution {
    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        int[][] numsBits = new int[length][2];
        for (int i = 0; i < length; i++) {
            numsBits[i][0] = arr[i];
            numsBits[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(numsBits, new Comparator<int[]>() {
            public int compare(int[] numBit1, int[] numBit2) {
                if (numBit1[1] != numBit2[1])
                    return numBit1[1] - numBit2[1];
                else
                    return numBit1[0] - numBit2[0];
            }
        });
        int[] sorted = new int[length];
        for (int i = 0; i < length; i++)
            sorted[i] = numsBits[i][0];
        return sorted;
    }
}