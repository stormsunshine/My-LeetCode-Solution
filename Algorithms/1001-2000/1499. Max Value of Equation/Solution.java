class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            map.put(point[0], i);
        }
        int[] differences = new int[length];
        for (int i = 0; i < length; i++)
            differences[i] = points[i][1] - points[i][0];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.offer(0);
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            int sum = x + y;
            while (!deque.isEmpty() && x - points[deque.peekFirst()][0] > k)
                deque.pollFirst();
            if (deque.isEmpty())
                deque.offerLast(i);
            else {
                int prevIndex = deque.peekLast();
                for (int j = prevIndex + 1; j < i; j++) {
                    while (!deque.isEmpty() && differences[deque.peekLast()] <= differences[j])
                        deque.pollLast();
                    deque.offerLast(j);
                }
                int prevMax = differences[deque.peekFirst()];
                int curSum = prevMax + sum;
                maxSum = Math.max(maxSum, curSum);
                while (!deque.isEmpty() && differences[deque.peekLast()] <= differences[i])
                    deque.pollLast();
                deque.offerLast(i);
            }
        }
        return maxSum;
    }
}