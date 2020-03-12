class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, columns = mat[0].length;
        int startRow = rows - 2, startColumn = 0;
        while (startRow > 0) {
            List<Integer> diagonalList = new ArrayList<Integer>();
            for (int i = startRow, j = startColumn; i < rows && j < columns; i++, j++)
                diagonalList.add(mat[i][j]);
            Collections.sort(diagonalList);
            for (int i = startRow, j = startColumn, index = 0; i < rows && j < columns; i++, j++, index++)
                mat[i][j] = diagonalList.get(index);
            startRow--;
        }
        if (startRow < 0)
            return mat;
        while (startColumn < columns) {
            List<Integer> diagonalList = new ArrayList<Integer>();
            for (int i = startRow, j = startColumn; i < rows && j < columns; i++, j++)
                diagonalList.add(mat[i][j]);
            Collections.sort(diagonalList);
            for (int i = startRow, j = startColumn, index = 0; i < rows && j < columns; i++, j++, index++)
                mat[i][j] = diagonalList.get(index);
            startColumn++;
        }
        return mat;
    }
}