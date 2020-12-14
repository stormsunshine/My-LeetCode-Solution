class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int length = boxes.length;
        int[] ports = new int[length + 1];
        int[] weights = new int[length + 1];
        int[] differences = new int[length + 1];
        long[] prefixWeights = new long[length + 1];
        for (int i = 1; i <= length; i++) {
            ports[i] = boxes[i - 1][0];
            weights[i] = boxes[i - 1][1];
            if (i > 1)
                differences[i] = differences[i - 1] + (ports[i - 1] != ports[i] ? 1 : 0);
            prefixWeights[i] = prefixWeights[i - 1] + weights[i];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offerLast(0);
        int[] dp = new int[length + 1];
        int[] remain = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            while (!deque.isEmpty() && (i - deque.peekFirst() > maxBoxes || prefixWeights[i] - prefixWeights[deque.peekFirst()] > maxWeight))
                deque.pollFirst();
            dp[i] = remain[deque.peekFirst()] + differences[i] + 2;
            if (i != length) {
                remain[i] = dp[i] - differences[i + 1];
                while (!deque.isEmpty() && remain[i] <= remain[deque.peekLast()])
                    deque.pollLast();
                deque.offerLast(i);
            }
        }
        return dp[length];
    }
}