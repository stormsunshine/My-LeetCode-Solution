class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea = 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] newMatrix = new int[rows][columns];
        for (int j = 0; j < columns; j++)
            newMatrix[0][j] = matrix[0][j];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1)
                    newMatrix[i][j] = newMatrix[i - 1][j] + 1;
            }
        }
        for (int i = 0; i < rows; i++) {
            int[] curRow = new int[columns];
            System.arraycopy(newMatrix[i], 0, curRow, 0, columns);
            Arrays.sort(curRow);
            for (int j = columns - 1; j >= 0; j--) {
                if (curRow[j] == 0)
                    break;
                int area = (columns - j) * curRow[j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}