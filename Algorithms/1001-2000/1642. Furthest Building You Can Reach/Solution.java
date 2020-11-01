class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        int maxIndex = 0;
        int length = heights.length;
        for (int i = 1; i < length && bricks >= 0; i++) {
            if (heights[i] <= heights[i - 1])
                maxIndex = i;
            else {
                int difference = heights[i] - heights[i - 1];
                bricks -= difference;
                priorityQueue.offer(difference);
                while (bricks < 0 && ladders > 0 && !priorityQueue.isEmpty()) {
                    bricks += priorityQueue.poll();
                    ladders--;
                }
                if (bricks >= 0)
                    maxIndex = i;
            }
        }
        return maxIndex;
    }
}