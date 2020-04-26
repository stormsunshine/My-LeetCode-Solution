class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] position1, int[] position2) {
                int sum1 = position1[0] + position1[1], sum2 = position2[0] + position2[1];
                if (sum1 != sum2)
                    return sum1 - sum2;
                else
                    return position2[0] - position1[0];
            }
        });
        int rows = nums.size();
        for (int i = 0; i < rows; i++) {
            int columns = nums.get(i).size();
            for (int j = 0; j < columns; j++)
                priorityQueue.offer(new int[]{i, j});
        }
        int size = priorityQueue.size();
        int[] orderArray = new int[size];
        for (int i = 0; i < size; i++) {
            int[] position = priorityQueue.poll();
            int row = position[0], column = position[1];
            orderArray[i] = nums.get(row).get(column);
        }
        return orderArray;
    }
}