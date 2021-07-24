class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                int time1 = pair1[1], time2 = pair2[1];
                if (Math.abs(time1) != Math.abs(time2))
                    return Math.abs(time1) - Math.abs(time2);
                else
                    return time1 - time2;
            }
        });
        int length = times.length;
        for (int i = 0; i < length; i++) {
            int arrival = times[i][0], leaving = times[i][1];
            priorityQueue.offer(new int[]{i, arrival});
            priorityQueue.offer(new int[]{i, -leaving});
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < length; i++)
            set.add(i);
        Map<Integer, Integer> seatMap = new HashMap<Integer, Integer>();
        while (!priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();
            int index = pair[0], time = pair[1];
            if (time > 0) {
                int first = set.first();
                set.remove(first);
                seatMap.put(index, first);
                if (index == targetFriend)
                    return first;
            } else {
                int seat = seatMap.get(index);
                set.add(seat);
            }
        }
        return -1;
    }
}