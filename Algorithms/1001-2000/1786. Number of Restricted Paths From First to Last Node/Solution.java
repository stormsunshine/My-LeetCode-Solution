class Solution {
    static final int MODULO = 1000000007;
    int restrictedPaths = 0;
    int n = 0;
    int[] dp;

    public int countRestrictedPaths(int n, int[][] edges) {
        this.n = n;
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            List<int[]> list1 = map.getOrDefault(u, new ArrayList<int[]>());
            List<int[]> list2 = map.getOrDefault(v, new ArrayList<int[]>());
            list1.add(new int[]{v, weight});
            list2.add(new int[]{u, weight});
            map.put(u, list1);
            map.put(v, list2);
        }
        int[] distances = getShortestDistances(n, map);
        dp = new int[n + 1];
        dp[n] = 1;
        return backtrack(distances, map, 1);
    }

    public int[] getShortestDistances(int n, Map<Integer, List<int[]>> map) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[n] = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer node1, Integer node2) {
                return distances[node1] - distances[node2];
            }
        });
        priorityQueue.offer(n);
        while (!priorityQueue.isEmpty()) {
            int node = priorityQueue.poll();
            int distance = distances[node];
            List<int[]> list = map.getOrDefault(node, new ArrayList<int[]>());
            for (int[] next : list) {
                int nextNode = next[0], weight = next[1];
                if (distance + weight < distances[nextNode]) {
                    distances[nextNode] = distance + weight;
                    priorityQueue.offer(nextNode);
                }
            }
        }
        return distances;
    }

    public int backtrack(int[] distances, Map<Integer, List<int[]>> map, int node) {
        if (dp[node] == 0) {
            int curDistance = distances[node];
            List<int[]> list = map.getOrDefault(node, new ArrayList<int[]>());
            for (int[] next : list) {
                int nextNode = next[0];
                if (distances[nextNode] < curDistance) {
                    int nextCount = backtrack(distances, map, nextNode);
                    dp[node] = (dp[node] + nextCount) % MODULO;
                }
            }
        }
        return dp[node];
    }
}