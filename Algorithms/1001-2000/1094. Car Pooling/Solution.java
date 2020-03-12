class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        for (int[] trip : trips) {
            int passengersCount = trip[0], start = trip[1], end = trip[2];
            int[] passengersStart = {start, passengersCount};
            int[] passengersEnd = {end, -passengersCount};
            priorityQueue.offer(passengersStart);
            priorityQueue.offer(passengersEnd);
        }
        int passengers = 0;
        while (!priorityQueue.isEmpty()) {
            int[] passengersChange = priorityQueue.poll();
            passengers += passengersChange[1];
            if (passengers > capacity)
                return false;
        }
        return true;
    }
}