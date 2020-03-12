class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (m == 0 || n == 0)
            return 0;
        int maxRow = m, maxColumn = n;
        for (int[] op : ops) {
            maxRow = Math.min(maxRow, op[0]);
            maxColumn = Math.min(maxColumn, op[1]);
        }
        long maxArea = (long) maxRow * (long) maxColumn;
        int maxCount = (int) maxArea;
        return maxCount;
    }
}