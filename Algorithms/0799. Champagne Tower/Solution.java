class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] amounts = new double[query_row + 1][];
        for (int i = 0; i <= query_row; i++)
            amounts[i] = new double[i + 1];
        amounts[0][0] = poured;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0], column = position[1];
            if (amounts[row][column] > 1) {
                double difference = amounts[row][column] - 1;
                amounts[row][column] = 1;
                if (row < query_row) {
                    amounts[row + 1][column] += difference / 2;
                    amounts[row + 1][column + 1] += difference / 2;
                    queue.offer(new int[]{row + 1, column});
                    queue.offer(new int[]{row + 1, column + 1});
                } else if (amounts[query_row][query_glass] == 1)
                    break;
            }
        }
        return amounts[query_row][query_glass];
    }
}