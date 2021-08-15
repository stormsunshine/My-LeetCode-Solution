class Solution {
    static final int WATER = -1;
    static final int WHITE = 0;
    static final int BLACK = 1;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = col - 1, high = row * col - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            boolean canCross = check(row, col, cells, mid);
            if (canCross)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    public boolean check(int row, int col, int[][] cells, int mid) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < mid; i++) {
            int[] cell = cells[i];
            grid[cell[0] - 1][cell[1] - 1] = WATER;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == WHITE) {
                grid[0][j] = BLACK;
                queue.offer(new int[]{0, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] direction : directions) {
                int newR = r + direction[0], newC = c + direction[1];
                if (newR >= 0 && newR < row && newC >= 0 && newC < col && grid[newR][newC] == WHITE) {
                    if (newR == row - 1)
                        return true;
                    grid[newR][newC] = BLACK;
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
        return false;
    }
}