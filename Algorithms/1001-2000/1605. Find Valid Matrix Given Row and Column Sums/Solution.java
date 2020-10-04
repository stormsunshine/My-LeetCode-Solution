class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length, columns = colSum.length;
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int num = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = num;
                rowSum[i] -= num;
                colSum[j] -= num;
            }
        }
        return matrix;
    }
}