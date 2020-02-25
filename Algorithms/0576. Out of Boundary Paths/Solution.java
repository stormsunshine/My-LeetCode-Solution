class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        final int MODULO = 1000000007;
        int outCounts = 0;
        int[][] counts = new int[m][n];
        counts[i][j] = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int move = 0; move < N; move++) {
            int[][] curCounts = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int column = 0; column < n; column++) {
                    int count = counts[row][column];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int newRow = row + direction[0], newColumn = column + direction[1];
                            if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n)
                                curCounts[newRow][newColumn] = (curCounts[newRow][newColumn] + count) % MODULO;
                            else
                                outCounts = (outCounts + count) % MODULO;
                        }
                    }
                }
            }
            for (int row = 0; row < m; row++) {
                for (int column = 0; column < n; column++)
                    counts[row][column] = curCounts[row][column];
            }
        }
        return outCounts;
    }
}