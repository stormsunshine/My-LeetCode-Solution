class Solution {
    public int[] findBall(int[][] grid) {
        int columns = grid[0].length;
        int[] bottoms = new int[columns];
        for (int i = 0; i < columns; i++)
            bottoms[i] = findBottom(grid, i);
        return bottoms;
    }

    public int findBottom(int[][] grid, int start) {
        int rows = grid.length, columns = grid[0].length;
        int row = 0, column = start;
        while (row < rows) {
            int curr = grid[row][column];
            if (curr == 1)
                column++;
            else
                column--;
            if (column < 0 || column >= columns)
                return -1;
            if (curr != grid[row][column])
                return -1;
            row++;
        }
        return column;
    }
}