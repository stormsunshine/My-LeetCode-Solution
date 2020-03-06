class Solution {
    public int minKBitFlips(int[] A, int K) {
        int flips = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (!queue.isEmpty() && queue.peek() + K == i)
                queue.poll();
            if (queue.size() % 2 == A[i]) {
                if (i + K > length)
                    return -1;
                else {
                    flips++;
                    queue.offer(i);
                }
            }
        }
        return flips;
    }
}