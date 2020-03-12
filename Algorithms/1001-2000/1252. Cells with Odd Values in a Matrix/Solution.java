class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rowsCount = new int[n];
        int[] columnsCount = new int[m];
        for (int[] index : indices) {
            int row = index[0], column = index[1];
            rowsCount[row]++;
            columnsCount[column]++;
        }
        int oddRows = 0, oddColumns = 0;
        for (int rowCount : rowsCount) {
            if (rowCount % 2 != 0)
                oddRows++;
        }
        for (int columnCount : columnsCount) {
            if (columnCount % 2 != 0)
                oddColumns++;
        }
        return oddRows * (m - oddColumns) + oddColumns * (n - oddRows);
    }
}