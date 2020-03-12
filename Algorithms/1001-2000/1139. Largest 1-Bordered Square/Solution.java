class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int maxSide = 0;
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    maxSide = Math.max(maxSide, 1);
                    int curMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < curMaxSide; k++) {
                        if (grid[i][j + k] == 0 || grid[i + k][j] == 0)
                            break;
                        if (grid[i + k][j + k] == 0)
                            continue;
                        boolean flag = true;
                        for (int m = 1; m < k; m++) {
                            if (grid[i + k][j + m] == 0 || grid[i + m][j + k] == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            maxSide = Math.max(maxSide, k + 1);
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}