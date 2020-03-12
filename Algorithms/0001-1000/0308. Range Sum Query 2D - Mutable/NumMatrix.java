class NumMatrix {
    int rows;
    int columns;
    int[][] matrix;
    int[][] rowSums;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0)
            return;
        rows = matrix.length;
        columns = matrix[0].length;
        rowSums = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            rowSums[i][0] = matrix[i][0];
            for (int j = 1; j < columns; j++)
                rowSums[i][j] = rowSums[i][j - 1] + matrix[i][j];
        }
    }
    
    public void update(int row, int col, int val) {
        int difference = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = col; i < columns; i++)
            rowSums[row][i] += difference;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2)
            return 0;
        int regionSum = 0;
        for (int i = row1; i <= row2; i++)
            regionSum += sumRow(i, col1, col2);
        return regionSum;
    }

    private int sumRow(int row, int col1, int col2) {
        int rowSum = rowSums[row][col2];
        if (col1 > 0)
            rowSum -= rowSums[row][col1 - 1];
        return rowSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */