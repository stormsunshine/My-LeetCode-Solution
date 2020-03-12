class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length, columns = grid[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][columns - 1] >= 0)
                break;
            for (int j = columns - 1; j >= 0; j--) {
                if (grid[i][j] < 0)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}