class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 == null || num2 == null ? 0 : num2 - num1;
            }
        });
        for (int stone : stones)
            priorityQueue.offer(stone);
        while (priorityQueue.size() > 1) {
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();
            if (stone1 > stone2)
                priorityQueue.offer(stone1 - stone2);
        }
        return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
    }
}