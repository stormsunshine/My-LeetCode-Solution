class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int pile : piles)
            priorityQueue.offer(pile);
        for (int i = 0; i < k; i++) {
            int pile = priorityQueue.poll();
            pile = pile - pile / 2;
            priorityQueue.offer(pile);
        }
        int sum = 0;
        while (!priorityQueue.isEmpty())
            sum += priorityQueue.poll();
        return sum;
    }
}