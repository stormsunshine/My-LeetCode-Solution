class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length, columns = mat[0].length;
        int[][] sums = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int minRow = Math.max(i - K, 0);
            int maxRow = Math.min(i + K, rows - 1);
            for (int j = 0; j < columns; j++) {
                int minColumn = Math.max(j - K, 0);
                int maxColumn = Math.min(j + K, columns - 1);
                for (int r = minRow; r <= maxRow; r++) {
                    for (int c = minColumn; c <= maxColumn; c++)
                        sums[i][j] += mat[r][c];
                }
            }
        }
        return sums;
    }
}