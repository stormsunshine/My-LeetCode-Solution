class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MODULO = 1000000007;
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            List<int[]> list1 = map.getOrDefault(u, new ArrayList<int[]>());
            List<int[]> list2 = map.getOrDefault(v, new ArrayList<int[]>());
            list1.add(new int[]{v, time});
            list2.add(new int[]{u, time});
            map.put(u, list1);
            map.put(v, list2);
        }
        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                long difference = times[num1] - times[num2];
                if (difference > 0)
                    return 1;
                else if (difference < 0)
                    return -1;
                else
                    return 0;
            }
        });
        priorityQueue.offer(0);
        while (!priorityQueue.isEmpty()) {
            int curNode = priorityQueue.poll();
            long curTime = times[curNode];
            List<int[]> list = map.getOrDefault(curNode, new ArrayList<int[]>());
            for (int[] road : list) {
                int nextNode = road[0], nextTime = road[1];
                long nextTotalTime = curTime + nextTime;
                if (nextTotalTime < times[nextNode]) {
                    times[nextNode] = nextTotalTime;
                    priorityQueue.offer(nextNode);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int[] counts = new int[n];
        visited[0] = true;
        counts[0] = 1;
        priorityQueue.offer(0);
        while (!priorityQueue.isEmpty()) {
            int size = priorityQueue.size();
            int curNode = priorityQueue.poll();
            long curTime = times[curNode];
            int curCount = counts[curNode];
            List<int[]> list = map.getOrDefault(curNode, new ArrayList<int[]>());
            for (int[] road : list) {
                int nextNode = road[0], nextTime = road[1];
                long nextTotalTime = curTime + nextTime;
                if (nextTotalTime == times[nextNode]) {
                    counts[nextNode] = (counts[nextNode] + curCount) % MODULO;
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        priorityQueue.offer(nextNode);
                    }
                }
            }
        }
        return counts[n - 1];
    }
}