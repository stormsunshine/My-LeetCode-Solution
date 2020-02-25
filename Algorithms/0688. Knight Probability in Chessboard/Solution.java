class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] probabilities = new double[N][N];
        probabilities[r][c] = 1;
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        for (int i = 0; i < K; i++) {
            double[][] curProbabilities = new double[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int row = j, column = k;
                    double probability = probabilities[j][k] / 8;
                    if (probability > 0) {
                        for (int[] direction : directions) {
                            int newRow = row + direction[0], newColumn = column + direction[1];
                            if (newRow >= 0 && newRow < N && newColumn >= 0 && newColumn < N)
                                curProbabilities[newRow][newColumn] += probability;
                        }
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    probabilities[j][k] = curProbabilities[j][k];
            }
        }
        double totalProbability = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                totalProbability += probabilities[i][j];
        }
        return totalProbability;
    }
}