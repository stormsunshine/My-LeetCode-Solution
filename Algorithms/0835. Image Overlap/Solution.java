class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverlap = 0;
        int sideLength = A.length;
        int maxMove = sideLength - 1;
        for (int i = -maxMove; i <= maxMove; i++) {
            for (int j = -maxMove; j <= maxMove; j++) {
                int overlap = 0;
                int rowStart = Math.max(0, i), rowEnd = Math.min(sideLength, sideLength + i);
                int columnStart = Math.max(0, j), columnEnd = Math.min(sideLength, sideLength + j);
                for (int row = rowStart; row < rowEnd; row++) {
                    for (int column = columnStart; column < columnEnd; column++) {
                        if (A[row][column] == 1 && B[row - i][column - j] == 1)
                            overlap++;
                    }
                }
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }
        return maxOverlap;
    }
}