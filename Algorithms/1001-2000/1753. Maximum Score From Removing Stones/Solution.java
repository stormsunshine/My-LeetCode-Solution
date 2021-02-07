class Solution {
    public int maximumScore(int a, int b, int c) {
        int score = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        priorityQueue.offer(a);
        priorityQueue.offer(b);
        priorityQueue.offer(c);
        while (priorityQueue.size() > 1) {
            int num1 = priorityQueue.poll() - 1;
            int num2 = priorityQueue.poll() - 1;
            score++;
            if (num1 > 0)
                priorityQueue.offer(num1);
            if (num2 > 0)
                priorityQueue.offer(num2);
        }
        return score;
    }
}