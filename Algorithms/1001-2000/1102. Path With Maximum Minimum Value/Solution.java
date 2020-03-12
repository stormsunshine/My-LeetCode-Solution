class Solution {
    public int maximumMinimumPath(int[][] A) {
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = A.length, columns = A[0].length;
        int[][] colors = new int[rows][columns];
        int[][] values = new int[rows][columns];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[2] != array2[2])
                    return array2[2] - array1[2];
                else if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        colors[0][0] = GRAY;
        values[0][0] = A[0][0];
        priorityQueue.offer(new int[]{0, 0, values[0][0]});
        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            int row = cell[0], column = cell[1], value = cell[2];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    values[newRow][newColumn] = Math.min(value, A[newRow][newColumn]);
                    priorityQueue.offer(new int[]{newRow, newColumn, values[newRow][newColumn]});
                }
            }
            colors[row][column] = BLACK;
        }
        return values[rows - 1][columns - 1];
    }
}