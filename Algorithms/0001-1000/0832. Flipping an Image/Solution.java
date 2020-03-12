class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length, columns = A[0].length;
        for (int i = 0; i < rows; i++) {
            int low = 0, high = columns - 1;
            while (low < high) {
                int temp = A[i][low];
                A[i][low] = A[i][high];
                A[i][high] = temp;
                low++;
                high--;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                A[i][j] = 1 - A[i][j];
        }
        return A;
    }
}