class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        int sum = 0;
        for (int num : target) {
            sum += num;
            priorityQueue.offer(num);
        }
        int length = target.length;
        while (sum > length) {
            int max = priorityQueue.poll();
            int difference = sum - max;
            if (difference == 0 || max - difference < 1)
                return false;
            int prev = max % difference == 0 ? difference : max % difference;
            sum -= (max - prev);
            priorityQueue.offer(prev);
        }
        return sum == length;
    }
}