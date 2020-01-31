class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int stick : sticks)
            priorityQueue.offer(stick);
        int cost = 0;
        while (priorityQueue.size() > 1) {
            int stick1 = priorityQueue.poll();
            int stick2 = priorityQueue.poll();
            int sum = stick1 + stick2;
            cost += sum;
            priorityQueue.offer(sum);
        }
        return cost;
    }
}