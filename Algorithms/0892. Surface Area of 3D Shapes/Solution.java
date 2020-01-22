class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int cell = grid[i][j];
                int curArea = cell == 0 ? 0 : cell * 4 + 2;
                for (int[] direction : directions) {
                    int newRow = i + direction[0], newColumn = j + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                        int adjacent = grid[newRow][newColumn];
                        int overlapArea = Math.min(cell, adjacent);
                        curArea -= overlapArea;
                    }
                }
                area += curArea;
            }
        }
        return area;
    }
}