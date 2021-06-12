class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int side = Math.min(m, n); side > 1; side--) {
            if (existMagicSquare(grid, m, n, side))
                return side;
        }
        return 1;
    }

    public boolean existMagicSquare(int[][] grid, int m, int n, int side) {
        int maxRow = m - side, maxColumn = n - side;
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                if (isMagicSquare(grid, i, j, side))
                    return true;
            }
        }
        return false;
    }

    public boolean isMagicSquare(int[][] grid, int startRow, int startColumn, int side) {
        Set<Integer> set = new HashSet<Integer>();
        int[] rowSums = new int[side];
        int[] columnSums = new int[side];
        int diagonal1 = 0, diagonal2 = 0;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                rowSums[i] += grid[startRow + i][startColumn + j];
                columnSums[j] += grid[startRow + i][startColumn + j];
                if (i == j)
                    diagonal1 += grid[startRow + i][startColumn + j];
                if (i + j == side - 1)
                    diagonal2 += grid[startRow + i][startColumn + j];
            }
        }
        for (int i = 0; i < side; i++) {
            set.add(rowSums[i]);
            set.add(columnSums[i]);
        }
        set.add(diagonal1);
        set.add(diagonal2);
        return set.size() == 1;
    }
}