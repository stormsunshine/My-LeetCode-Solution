class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> zeroRows = new ArrayList<Integer>();
        List<Integer> zeroColumns = new ArrayList<Integer>();
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    if (!zeroRows.contains(i))
                        zeroRows.add(i);
                    if (!zeroColumns.contains(j))
                        zeroColumns.add(j);
                }
            }
        }
        for (int row : zeroRows) {
            for (int j = 0; j < columns; j++)
                matrix[row][j] = 0;
        }
        for (int column : zeroColumns) {
            for (int i = 0; i < rows; i++)
                matrix[i][column] = 0;
        }
    }
}