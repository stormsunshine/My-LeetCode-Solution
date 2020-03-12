class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, columns = matrix[0].length;
        int low = 0, high = rows * columns - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = matrix[mid / columns][mid % columns];
            if (num == target)
                return true;
            else if (num > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}