class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graphMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1], insertions = edge[2];
            Map<Integer, Integer> map0 = graphMap.getOrDefault(node0, new HashMap<Integer, Integer>());
            Map<Integer, Integer> map1 = graphMap.getOrDefault(node1, new HashMap<Integer, Integer>());
            map0.put(node1, insertions);
            map1.put(node0, insertions);
            graphMap.put(node0, map0);
            graphMap.put(node1, map1);
        }
        int[] distances = new int[N];
        Arrays.fill(distances, M + 1);
        distances[0] = 0;
        int[][] used = new int[N][N];
        int reachable = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] nodeDistance1, int[] nodeDistance2) {
                return nodeDistance1[1] - nodeDistance2[1];
            }
        });
        priorityQueue.offer(new int[]{0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] nodeDistance = priorityQueue.poll();
            int node = nodeDistance[0], distance = nodeDistance[1];
            if (distance > distances[node])
                continue;
            reachable++;
            if (graphMap.containsKey(node)) {
                Map<Integer, Integer> edgesMap = graphMap.get(node);
                Set<Integer> keySet = edgesMap.keySet();
                for (int adjacent : keySet) {
                    int insertions = edgesMap.get(adjacent);
                    int currReachable = Math.min(insertions, M - distance);
                    used[node][adjacent] = currReachable;
                    int newDistance = distance + insertions + 1;
                    if (newDistance < distances[adjacent]) {
                        distances[adjacent] = newDistance;
                        priorityQueue.offer(new int[]{adjacent, newDistance});
                    }
                }
            }
        }
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1], insertions = edge[2];
            reachable += Math.min(insertions, used[node0][node1] + used[node1][node0]);
        }
        return reachable;
    }
}