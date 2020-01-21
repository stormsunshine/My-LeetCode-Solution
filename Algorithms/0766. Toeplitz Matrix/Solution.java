class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int row = rows - 1, column = 0;
        while (row > 0) {
            row--;
            int num = matrix[row][column];
            for (int i = row + 1, j = column + 1; i < rows && j < columns; i++, j++) {
                int curNum = matrix[i][j];
                if (curNum != num)
                    return false;
            }
        }
        while (column < columns) {
            int num = matrix[row][column];
            for (int i = row + 1, j = column + 1; i < rows && j < columns; i++, j++) {
                int curNum = matrix[i][j];
                if (curNum != num)
                    return false;
            }
            column++;
        }
        return true;
    }
}