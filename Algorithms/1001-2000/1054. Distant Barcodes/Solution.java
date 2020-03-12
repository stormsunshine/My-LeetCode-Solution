class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] counts = new int[10001];
        int maxCount = 0;
        int length = barcodes.length;
        for (int i = 0; i < length; i++) {
            int num = barcodes[i];
            counts[num]++;
            maxCount = Math.max(maxCount, counts[num]);
        }
        int[] rearrangeBarcodes = new int[length];
        int evenIndex = 0, oddIndex = 1;
        int maxPossible = length / 2 + 1;
        for (int i = 1; i <= 10000; i++) {
            while (counts[i] > 0 && counts[i] < maxPossible && oddIndex < length) {
                rearrangeBarcodes[oddIndex] = i;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                rearrangeBarcodes[evenIndex] = i;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return rearrangeBarcodes;
    }
}