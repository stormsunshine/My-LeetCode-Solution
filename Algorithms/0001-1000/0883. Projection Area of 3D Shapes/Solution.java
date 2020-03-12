class Solution {
    public int projectionArea(int[][] grid) {
        int areaTop = 0, areaFront = 0, areaSide = 0;
        int rows = grid.length, columns = grid[0].length;
        int[] maxEachRow = new int[rows];
        int[] maxEachColumn = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int cell = grid[i][j];
                if (cell != 0)
                    areaTop++;
                maxEachRow[i] = Math.max(maxEachRow[i], cell);
                maxEachColumn[j] = Math.max(maxEachColumn[j], cell);
            }
        }
        for (int num : maxEachRow)
            areaSide += num;
        for (int num : maxEachColumn)
            areaFront += num;
        return areaTop + areaFront + areaSide;
    }
}