class Solution {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int block : blocks)
            priorityQueue.offer(block);
        while (priorityQueue.size() > 1) {
            priorityQueue.poll();
            int secondSmallest = priorityQueue.poll();
            int newTime = secondSmallest + split;
            priorityQueue.offer(newTime);
        }
        return priorityQueue.poll();
    }
}