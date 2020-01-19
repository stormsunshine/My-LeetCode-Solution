class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int originalRows = nums.length, originalColumns = nums[0].length;
        if (originalRows * originalColumns != r * c)
            return nums;
        int[][] reshape = new int[r][c];
        int total = originalRows * originalColumns;
        for (int i = 0; i < total; i++) {
            int originalRow = i / originalColumns, originalColumn = i % originalColumns;
            int currentRow = i / c, currentColumn = i % c;
            reshape[currentRow][currentColumn] = nums[originalRow][originalColumn];
        }
        return reshape;
    }
}