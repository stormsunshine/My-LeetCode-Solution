class Solution {
    public int[] prevPermOpt1(int[] A) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        int swapIndex = -1;
        int swapNum = 0;
        int length = A.length;
        for (int i = length - 1; i > 0; i--) {
            int num = A[i];
            priorityQueue.offer(new int[]{num, i});
            if (num < A[i - 1]) {
                swapIndex = i - 1;
                swapNum = A[i - 1];
                break;
            }
        }
        if (swapIndex < 0)
            return A;
        int nextSwapNum = 0, nextSwapIndex = -1;
        while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < swapNum) {
            int[] numIndex = priorityQueue.poll();
            nextSwapNum = numIndex[0];
            nextSwapIndex = numIndex[1];
        }
        A[swapIndex] = nextSwapNum;
        A[nextSwapIndex] = swapNum;
        return A;
    }
}