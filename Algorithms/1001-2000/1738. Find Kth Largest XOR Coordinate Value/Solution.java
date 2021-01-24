class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] rowXORs = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            rowXORs[i][0] = matrix[i][0];
            for (int j = 1; j < columns; j++)
                rowXORs[i][j] = rowXORs[i][j - 1] ^ matrix[i][j];
        }
        int[][] totalXORs = new int[rows][columns];
        for (int j = 0; j < columns; j++)
            totalXORs[0][j] = rowXORs[0][j];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                totalXORs[i][j] = totalXORs[i - 1][j] ^ rowXORs[i][j];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                priorityQueue.offer(totalXORs[i][j]);
                if (priorityQueue.size() > k)
                    priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}