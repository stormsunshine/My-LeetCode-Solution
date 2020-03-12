class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] flags = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                flags[i][j] = true;
        }
        int count = 0;
        int maxSide = Math.min(rows, columns);
        for (int side = 1; side <= maxSide; side++) {
            int rowEnd = rows - side, columnEnd = columns - side;
            for (int i = 0; i <= rowEnd; i++) {
                int fromRow = i, toRow = i + side - 1;
                for (int j = 0; j <= columnEnd; j++) {
                    if (!flags[i][j])
                        continue;
                    int fromColumn = j, toColumn = j + side - 1;
                    boolean isAllOne = true;
                    outer:
                    for (int row = fromRow; row <= toRow; row++) {
                        for (int column = fromColumn; column <= toColumn; column++) {
                            if (matrix[row][column] != 1) {
                                flags[i][j] = false;
                                isAllOne = false;
                                break outer;
                            }
                        }
                    }
                    if (isAllOne)
                        count++;
                }
            }
        }
        return count;
    }
}