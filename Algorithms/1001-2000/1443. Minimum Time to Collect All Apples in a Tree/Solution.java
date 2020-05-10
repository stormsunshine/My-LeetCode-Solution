class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> adjacentMap = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            Set<Integer> set0 = adjacentMap.getOrDefault(node0, new HashSet<Integer>());
            Set<Integer> set1 = adjacentMap.getOrDefault(node1, new HashSet<Integer>());
            set0.add(node1);
            set1.add(node0);
            adjacentMap.put(node0, set0);
            adjacentMap.put(node1, set1);
        }
        Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>> childrenMap = new HashMap<Integer, Set<Integer>>();
        parentMap.put(0, -1);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int distance = distances[node];
            Set<Integer> adjacentSet = adjacentMap.getOrDefault(node, new HashSet<Integer>());
            Set<Integer> childrenSet = childrenMap.getOrDefault(node, new HashSet<Integer>());
            for (int nextNode : adjacentSet) {
                if (!visited[nextNode]) {
                    parentMap.put(nextNode, node);
                    childrenSet.add(nextNode);
                    visited[nextNode] = true;
                    distances[nextNode] = distance + 1;
                    queue.offer(nextNode);
                }
            }
            childrenMap.put(node, childrenSet);
        }
        int minTime = 0;
        boolean[] bottomUpVisited = new boolean[n];
        Queue<Integer> bottomUpQueue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                bottomUpVisited[i] = true;
                bottomUpQueue.offer(i);
            }
        }
        while (!bottomUpQueue.isEmpty()) {
            int node = bottomUpQueue.poll();
            int parent = parentMap.get(node);
            if (parent >= 0) {
                minTime += 2;
                if (!bottomUpVisited[parent]) {
                    bottomUpVisited[parent] = true;
                    bottomUpQueue.offer(parent);
                }
            }
        }
        return minTime;
    }
}