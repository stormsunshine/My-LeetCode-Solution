class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int cell = grid[i][j];
                if (cell == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0)
                    perimeter++;
                if (i == rows - 1 || grid[i + 1][j] == 0)
                    perimeter++;
                if (j == 0 || grid[i][j - 1] == 0)
                    perimeter++;
                if (j == columns - 1 || grid[i][j + 1] == 0)
                    perimeter++;
            }
        }
        return perimeter;
    }
}