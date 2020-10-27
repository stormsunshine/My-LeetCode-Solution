class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int total = rows * columns;
        int[] parents = new int[total];
        int[] ranks1D = new int[total];
        Integer[] indices = new Integer[total];
        for (int i = 0; i < total; i++) {
            parents[i] = i;
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return matrix[index1 / columns][index1 % columns] - matrix[index2 / columns][index2 % columns];
            }
        });
        int[] rowMaxRanks = new int[rows];
        int[] columnMaxRanks = new int[columns];
        Arrays.fill(rowMaxRanks, -1);
        Arrays.fill(columnMaxRanks, -1);
        for (int i = 0; i < total; i++) {
            int rank = 1;
            int index = indices[i];
            int row = index / columns, column = index % columns;
            if (rowMaxRanks[row] != -1) {
                int maxColumn = rowMaxRanks[row];
                int maxIndex = row * columns + maxColumn;
                int rootIndex = find(parents, maxIndex);
                int rootRank = ranks1D[rootIndex];
                if (matrix[row][column] == matrix[row][maxColumn]) {
                    union(parents, index, maxIndex);
                    rank = rootRank;
                } else
                    rank = rootRank + 1;
            }
            if (columnMaxRanks[column] != -1) {
                int maxRow = columnMaxRanks[column];
                int maxIndex = maxRow * columns + column;
                int rootIndex = find(parents, maxIndex);
                int rootRank = ranks1D[rootIndex];
                if (matrix[row][column] == matrix[maxRow][column]) {
                    union(parents, index, maxIndex);
                    rank = Math.max(rank, rootRank);
                } else
                    rank = Math.max(rank, rootRank + 1);
            }
            rowMaxRanks[row] = column;
            columnMaxRanks[column] = row;
            ranks1D[find(parents, index)] = rank;
        }
        int[][] ranks = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = i * columns + j;
                ranks[i][j] = ranks1D[find(parents, index)];
            }
        }
        return ranks;
    }

    public void union(int[] parents, int index1, int index2) {
        parents[find(parents, index1)] = find(parents, index2);
    }

    public int find(int[] parents, int index) {
        if (parents[index] != index)
            parents[index] = find(parents, parents[index]);
        return parents[index];
    }
}