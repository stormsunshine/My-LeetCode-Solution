class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        if (rows < 3 || columns < 3)
            return 0;
        int count = 0;
        int rowEnd = rows - 3, columnEnd = columns - 3;
        for (int i = 0; i <= rowEnd; i++) {
            for (int j = 0; j <= columnEnd; j++) {
                if (isMagicSquare(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    public boolean isMagicSquare(int[][] grid, int startRow, int startColumn) {
        if (grid[startRow + 1][startColumn + 1] != 5)
            return false;
        boolean[] exists = new boolean[16];
        exists[5] = true;
        int sumRow1 = 0, sumRow2 = 0, sumColumn1 = 0, sumColumn2 = 0;
        for (int i = 0; i < 3; i++) {
            int num1 = grid[startRow][startColumn + i];
            int num2 = grid[startRow + 2][startColumn + i];
            int num3 = grid[startRow + i][startColumn];
            int num4 = grid[startRow + i][startColumn + 2];
            exists[num1] = true;
            exists[num2] = true;
            exists[num3] = true;
            exists[num4] = true;
            sumRow1 += num1;
            sumRow2 += num2;
            sumColumn1 += num3;
            sumColumn2 += num4;
        }
        for (int i = 1; i <= 9; i++) {
            if (!exists[i])
                return false;
        }
        return sumRow1 == 15 && sumRow2 == 15 && sumColumn1 == 15 && sumColumn2 == 15;
    }
}