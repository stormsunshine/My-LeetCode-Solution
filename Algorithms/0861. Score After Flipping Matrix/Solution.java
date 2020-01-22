class Solution {
    public int matrixScore(int[][] A) {
        int rows = A.length, columns = A[0].length;
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < columns; j++)
                    A[i][j] = 1 - A[i][j];
            }
        }
        for (int i = 1; i < columns; i++) {
            int ones = 0;
            for (int j = 0; j < rows; j++)
                ones += A[j][i];
            if (ones < rows - ones) {
                for (int j = 0; j < rows; j++)
                    A[j][i] = 1 - A[j][i];
            }
        }
        int score = 0;
        for (int i = 0; i < rows; i++) {
            int[] row = A[i];
            int curScore = 0;
            for (int j = 0; j < columns; j++) {
                curScore *= 2;
                curScore += row[j];
            }
            score += curScore;
        }
        return score;
    }
}