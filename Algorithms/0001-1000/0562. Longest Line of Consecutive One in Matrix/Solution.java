class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int maxLength = 0;
        int rows = M.length, columns = M[0].length;
        int[][][] lines = new int[rows][columns][4];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < 4; k++)
                        lines[i][j][k] = 1;
                    if (j > 0 && M[i][j - 1] == 1)
                        lines[i][j][0] = lines[i][j - 1][0] + 1;
                    if (i > 0 && M[i - 1][j] == 1)
                        lines[i][j][1] = lines[i - 1][j][1] + 1;
                    if (i > 0 && j > 0 && M[i - 1][j - 1] == 1)
                        lines[i][j][2] = lines[i - 1][j - 1][2] + 1;
                    if (i > 0 && j < columns - 1 && M[i - 1][j + 1] == 1)
                        lines[i][j][3] = lines[i - 1][j + 1][3] + 1;
                    for (int k = 0; k < 4; k++)
                        maxLength = Math.max(maxLength, lines[i][j][k]);
                }
            }
        }
        return maxLength;
    }
}