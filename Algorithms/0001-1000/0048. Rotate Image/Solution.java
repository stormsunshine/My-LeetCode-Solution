class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null)
            return;
        int side = matrix.length;
        if (side <= 1)
            return;
        int firstCircle = 0;
        int lastCircle = side / 2 - 1;
        for (int i = firstCircle; i <= lastCircle; i++) {
            int begin = i;
            int end = side - 2 - i;
            for (int j = begin; j <= end; j++) {
                int[] indices = {i, j, side - 1 - i, side - 1 - j};
                rotateFourSquares(matrix, indices);
            }
        }
    }

    public void rotateFourSquares(int[][] matrix, int[] indices) {
        int temp = matrix[indices[0]][indices[1]];
        matrix[indices[0]][indices[1]] = matrix[indices[3]][indices[0]];
        matrix[indices[3]][indices[0]] = matrix[indices[2]][indices[3]];
        matrix[indices[2]][indices[3]] = matrix[indices[1]][indices[2]];
        matrix[indices[1]][indices[2]] = temp;
    }
}