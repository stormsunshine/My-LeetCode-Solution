/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), columns = dimensions.get(1);
        int leftMostColumn = columns;
        for (int i = 0; i < rows; i++) {
            int low = 0, high = leftMostColumn - 1;
            if (binaryMatrix.get(i, high) == 0)
                continue;
            leftMostColumn = Math.min(leftMostColumn, high);
            while (low < high) {
                int mid = (high - low) / 2 + low;
                int num = binaryMatrix.get(i, mid);
                if (num == 1) {
                    high = mid;
                    leftMostColumn = Math.min(leftMostColumn, mid);
                } else
                    low = mid + 1;
            }
            if (leftMostColumn == 0)
                break;
        }
        return leftMostColumn == columns ? -1 : leftMostColumn;
    }
}