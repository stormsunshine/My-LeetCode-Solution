class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return M;
        int rows = M.length, columns = M[0].length;
        int[][] smooth = new int[rows][columns];
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int[] direction : directions) {
                    int newRow = i + direction[0], newColumn = j + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                        sum += M[newRow][newColumn];
                        count++;
                    }
                }
                smooth[i][j] = sum / count;
            }
        }
        return smooth;
    }
}