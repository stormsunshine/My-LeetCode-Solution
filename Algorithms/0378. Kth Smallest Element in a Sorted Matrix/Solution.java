class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int low = matrix[0][0], high = matrix[rows - 1][columns - 1];
        while (low < high) {
            int target = (high - low) / 2 + low;
            int count = countTarget(matrix, target);
            if (count < k)
                low = target + 1;
            else
                high = target;
        }
        return low;
    }

    public int countTarget(int[][] matrix, int target) {
        int count = 0;
        int rows = matrix.length, columns = matrix[0].length;
        int row = rows - 1, column = 0;
        while (row >= 0 && column < columns) {
            if (matrix[row][column] <= target) {
                count += row + 1;
                column++;
            } else
                row--;
        }
        return count;
    }
}