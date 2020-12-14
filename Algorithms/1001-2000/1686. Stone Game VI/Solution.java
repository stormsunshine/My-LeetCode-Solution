class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[2] - array1[2];
            }
        });
        int length = aliceValues.length;
        for (int i = 0; i < length; i++)
            priorityQueue.offer(new int[]{aliceValues[i], bobValues[i], aliceValues[i] + bobValues[i]});
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < length; i++) {
            int[] array = priorityQueue.poll();
            if (i % 2 == 0)
                aliceScore += array[0];
            else
                bobScore += array[1];
        }
        if (aliceScore > bobScore)
            return 1;
        else if (aliceScore < bobScore)
            return -1;
        else
            return 0;
    }
}