class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> travelMap = new HashMap<Integer, List<int[]>>();
        for (int[] time : times) {
            int source = time[0] - 1, target = time[1] - 1, lapse = time[2];
            List<int[]> travels = travelMap.getOrDefault(source, new ArrayList<int[]>());
            travels.add(new int[]{target, lapse});
            travelMap.put(source, travels);
        }
        int[] received = new int[N];
        for (int i = 0; i < N; i++)
            received[i] = Integer.MAX_VALUE;
        received[K - 1] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{K - 1, 0});
        while (!queue.isEmpty()) {
            int[] nodeTime = queue.poll();
            int node = nodeTime[0], time = nodeTime[1];
            List<int[]> travels = travelMap.getOrDefault(node, new ArrayList<int[]>());
            for (int[] travel : travels) {
                int target = travel[0], lapse = travel[1];
                int totalLapse = time + lapse;
                if (totalLapse < received[target]) {
                    received[target] = totalLapse;
                    queue.offer(new int[]{target, totalLapse});
                }
            }
        }
        int maxTime = 0;
        for (int time : received) {
            if (time == Integer.MAX_VALUE)
                return -1;
            else
                maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}