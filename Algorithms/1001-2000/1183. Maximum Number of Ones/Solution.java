class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] counts = new int[sideLength][sideLength];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                counts[i % sideLength][j % sideLength]++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++)
                priorityQueue.offer(counts[i][j]);
        }
        int maxTotalOnes = 0;
        for (int i = 0; i < maxOnes; i++)
            maxTotalOnes += priorityQueue.poll();
        return maxTotalOnes;
    }
}