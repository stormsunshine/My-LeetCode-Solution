class Solution {
    public int shortestSubarray(int[] A, int K) {
        int length = A.length;
        long[] prefixSums = new long[length + 1];
        for (int i = 1; i <= length; i++)
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        int subarrayLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i <= length; i++) {
            while (!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.peekLast()])
                deque.pollLast();
            while (!deque.isEmpty() && prefixSums[i] >= prefixSums[deque.peekFirst()] + K)
                subarrayLength = Math.min(subarrayLength, i - deque.pollFirst());
            deque.offerLast(i);
        }
        return subarrayLength <= length ? subarrayLength : -1;
    }
}