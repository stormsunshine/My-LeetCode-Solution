class Solution {
    public int minSwaps(int[][] grid) {
        int side = grid.length;
        int[] zerosCounts = new int[side];
        for (int i = 0; i < side; i++) {
            int[] row = grid[i];
            int zerosCount = 0;
            for (int j = side - 1; j >= 0; j--) {
                if (row[j] == 0)
                    zerosCount++;
                else
                    break;
            }
            zerosCounts[i] = zerosCount;
        }
        int swaps = 0;
        for (int i = 0; i < side; i++) {
            int minZeros = side - i - 1;
            if (zerosCounts[i] < minZeros) {
                int firstRowIndex = -1;
                for (int j = i + 1; j < side; j++) {
                    if (zerosCounts[j] >= minZeros) {
                        firstRowIndex = j;
                        break;
                    }
                }
                if (firstRowIndex < 0)
                    return -1;
                for (int j = firstRowIndex; j > i; j--) {
                    swaps++;
                    int temp = zerosCounts[j];
                    zerosCounts[j] = zerosCounts[j - 1];
                    zerosCounts[j - 1] = temp;
                }
            }
        }
        return swaps;
    }
}