class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requests = new int[k];
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < k; i++)
            set.add(i);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array1[1] - array2[1];
            }
        });
        int length = arrival.length;
        for (int i = 0; i < length; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= arrival[i])
                set.add(priorityQueue.poll()[0]);
            int server = i % k;
            if (!set.isEmpty()) {
                Integer nextServer = set.ceiling(server);
                if (nextServer == null)
                    nextServer = set.first();
                requests[nextServer]++;
                set.remove(nextServer);
                priorityQueue.offer(new int[]{nextServer, arrival[i] + load[i]});
            }
        }
        int maxRequests = requests[0];
        for (int i = 1; i < k; i++)
            maxRequests = Math.max(maxRequests, requests[i]);
        List<Integer> busiest = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequests)
                busiest.add(i);
        }
        return busiest;
    }
}