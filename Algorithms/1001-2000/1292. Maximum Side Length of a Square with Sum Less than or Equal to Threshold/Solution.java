class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length, columns = mat[0].length;
        int maxSideLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int maxSide = Math.min(rows - i, columns - j);
                int sum = mat[i][j];
                if (sum > threshold)
                    break;
                maxSideLength = Math.max(maxSideLength, 1);
                for (int k = 2; k <= maxSide; k++) {
                    int nextRowIndex = i + k - 1, nextColumnIndex = j + k - 1;
                    for (int m = j; m < nextColumnIndex; m++)
                        sum += mat[nextRowIndex][m];
                    for (int m = i; m < nextRowIndex; m++)
                        sum += mat[m][nextColumnIndex];
                    sum += mat[nextRowIndex][nextColumnIndex];
                    if (sum <= threshold)
                        maxSideLength = Math.max(maxSideLength, k);
                }
            }
        }
        return maxSideLength;
    }
}