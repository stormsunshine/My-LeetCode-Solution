class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Map<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        int length = A.length;
        for (int i = 0; i < length; i++)
            numIndexMap.put(A[i], i);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] fraction1, int[] fraction2) {
                return fraction1[0] * fraction2[1] - fraction2[0] * fraction1[1];
            }
        });
        for (int i = 1; i < length; i++) {
            int[] fraction = {A[0], A[i]};
            priorityQueue.add(fraction);
        }
        for (int i = 1; i < K; i++) {
            int[] fraction = priorityQueue.poll();
            int numeratorIndex = numIndexMap.get(fraction[0]), denominatorIndex = numIndexMap.get(fraction[1]);
            if (numeratorIndex + 1 < denominatorIndex) {
                numeratorIndex++;
                int[] newFraction = {A[numeratorIndex], fraction[1]};
                priorityQueue.offer(newFraction);
            }
        }
        return priorityQueue.peek();
    }
}