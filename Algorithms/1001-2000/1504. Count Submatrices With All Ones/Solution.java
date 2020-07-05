class Solution {
    public int numSubmat(int[][] mat) {
        int count = 0;
        int rows = mat.length, columns = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1) {
                    int maxPossible = columns - 1;
                    for (int k = i; k < rows; k++) {
                        int maxColumn = j - 1;
                        for (int m = j; m <= maxPossible; m++) {
                            if (mat[k][m] == 1)
                                maxColumn = m;
                            else {
                                maxPossible = Math.min(maxPossible, maxColumn);
                                break;
                            }
                        }
                        int curColumns = maxColumn - j + 1;
                        int curCount = curColumns;
                        count += curCount;
                    }
                }
            }
        }
        return count;
    }
}