class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            sums = matrix;
        else {
            int rows = matrix.length, columns = matrix[0].length;
            sums = new int[rows][columns];
            sums[0][0] = matrix[0][0];
            for (int i = 1; i < rows; i++)
                sums[i][0] = sums[i - 1][0] + matrix[i][0];
            for (int i = 1; i < columns; i++)
                sums[0][i] = sums[0][i - 1] + matrix[0][i];
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++)
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rows = sums.length, columns = sums[0].length;
        row1 = Math.max(row1, 0);
        col1 = Math.max(col1, 0);
        row2 = Math.min(row2, rows - 1);
        col2 = Math.min(col2, columns - 1);
        if (row1 == 0 && col1 == 0)
            return sums[row2][col2];
        else if (row1 == 0)
            return sums[row2][col2] - sums[row2][col1 - 1];
        else if (col1 == 0)
            return sums[row2][col2] - sums[row1 - 1][col2];
        else
            return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */