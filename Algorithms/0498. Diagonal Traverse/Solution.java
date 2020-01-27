public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int rows = matrix.length, columns = matrix[0].length;
        int totalElements = rows * columns;
        int[] order = new int[totalElements];
        int vertical = -1, horizontal = 1;
        int row = 0, column = 0;
        for (int i = 0; i < totalElements; i++) {
            order[i] = matrix[row][column];
            row += vertical;
            column += horizontal;
            if (row < 0 && column >= columns) {
                row = 1;
                column = columns - 1;
                vertical = 1;
                horizontal = -1;
            } else if (row >= rows && column < 0) {
                row = rows - 1;
                column = 1;
                vertical = -1;
                horizontal = 1;
            } else if (row < 0) {
                row = 0;
                vertical = 1;
                horizontal = -1;
            } else if (row >= rows) {
                row = rows - 1;
                column += 2;
                vertical = -1;
                horizontal = 1;
            } else if (column < 0) {
                column = 0;
                vertical = -1;
                horizontal = 1;
            } else if (column >= columns) {
                column = columns - 1;
                row += 2;
                vertical = 1;
                horizontal = -1;
            }
        }
        return order;
    }
}