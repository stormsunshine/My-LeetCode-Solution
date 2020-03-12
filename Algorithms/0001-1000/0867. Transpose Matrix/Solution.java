class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length, columns = A[0].length;
        int[][] transpose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                transpose[j][i] = A[i][j];
        }
        return transpose;
    }
}