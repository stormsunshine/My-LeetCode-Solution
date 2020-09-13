class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int rows = mat.length, columns = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1) {
                    if (isSpecial(mat, i, j))
                        count++;
                }
            }
        }
        return count;
    }

    public boolean isSpecial(int[][] mat, int row, int column) {
        int rows = mat.length, columns = mat[0].length;
        for (int i = 0; i < rows; i++) {
            if (i == row)
                continue;
            if (mat[i][column] == 1)
                return false;
        }
        for (int j = 0; j < columns; j++) {
            if (j == column)
                continue;
            if (mat[row][j] == 1)
                return false;
        }
        return true;
    }
}