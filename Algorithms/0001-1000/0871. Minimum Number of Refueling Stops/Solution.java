class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        int refuels = 0;
        int remain = startFuel;
        int prevPosition = 0;
        int length = stations.length;
        for (int i = 0; i < length; i++) {
            int[] station = stations[i];
            int position = station[0], gas = station[1];
            remain -= position - prevPosition;
            while (!priorityQueue.isEmpty() && remain < 0) {
                remain += priorityQueue.poll();
                refuels++;
            }
            if (remain < 0)
                return -1;
            priorityQueue.offer(gas);
            prevPosition = position;
        }
        remain -= target - prevPosition;
        while (!priorityQueue.isEmpty() && remain < 0) {
            remain += priorityQueue.poll();
            refuels++;
        }
        if (remain < 0)
            return -1;
        else
            return refuels;
    }
}