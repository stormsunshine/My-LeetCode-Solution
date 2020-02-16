class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] event1, int[] event2) {
                if (event1[0] != event2[0])
                    return event1[0] - event2[0];
                else
                    return event1[1] - event2[1];
            }
        });
        for (int[] event : events)
            priorityQueue.offer(event);
        int count = 0;
        int curDay = 1;
        while (!priorityQueue.isEmpty()) {
            int[] event = priorityQueue.poll();
            curDay = Math.max(curDay, event[0]);
            if (curDay <= event[1]) {
                curDay++;
                count++;
            }
            while (!priorityQueue.isEmpty()) {
                int[] nextEvent = priorityQueue.poll();
                if (curDay <= nextEvent[0]) {
                    priorityQueue.offer(nextEvent);
                    break;
                }
                if (curDay <= nextEvent[1]) {
                    nextEvent[0] = curDay;
                    priorityQueue.offer(nextEvent);
                }
            }
        }
        return count;
    }
}