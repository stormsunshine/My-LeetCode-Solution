class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, columns = matrix[0].length;
        return searchMatrix(matrix, 0, rows - 1, 0, columns - 1, target);
    }

    public boolean searchMatrix(int[][] matrix, int up, int down, int left, int right, int target) {
        if (up > down || left > right)
            return false;
        if (up == down && left == right)
            return matrix[up][left] == target;
        int midRow = (down - up) / 2 + up, midColumn = (right - left) / 2 + left;
        int num = matrix[midRow][midColumn];
        if (num == target)
            return true;
        else if (num > target) {
            return searchMatrix(matrix, up, midRow - 1, left, right, target) || searchMatrix(matrix, midRow, down, left, midColumn - 1, target);
        } else {
            return searchMatrix(matrix, up, midRow, midColumn + 1, right, target) || searchMatrix(matrix, midRow + 1, down, left, right, target);
        }
    }
}