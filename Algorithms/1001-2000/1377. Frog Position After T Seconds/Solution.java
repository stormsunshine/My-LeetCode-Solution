class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, Set<Integer>> edgesMap = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            int vertex0 = edge[0] - 1, vertex1 = edge[1] - 1;
            Set<Integer> next0 = edgesMap.getOrDefault(vertex0, new HashSet<Integer>());
            next0.add(vertex1);
            edgesMap.put(vertex0, next0);
            Set<Integer> next1 = edgesMap.getOrDefault(vertex1, new HashSet<Integer>());
            next1.add(vertex0);
            edgesMap.put(vertex1, next1);
        }
        int[] parents = new int[n];
        parents[0] = -1;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.offer(0);
        while (!bfsQueue.isEmpty()) {
            int vertex = bfsQueue.poll();
            Set<Integer> nextVertices = edgesMap.getOrDefault(vertex, new HashSet<Integer>());
            for (int nextVertex : nextVertices) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    parents[nextVertex] = vertex;
                    bfsQueue.offer(nextVertex);
                }
            }
        }
        int targetPathLength = 0;
        Set<Integer> targetPathSet = new HashSet<Integer>();
        targetPathSet.add(target - 1);
        int curVertex = target - 1;
        while (curVertex != 0) {
            curVertex = parents[curVertex];
            targetPathLength++;
            targetPathSet.add(curVertex);
        }
        if (targetPathLength > t)
            return 0;
        Map<Integer, Set<Integer>> childrenMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            int parent = parents[i];
            if (parent >= 0) {
                Set<Integer> children = childrenMap.getOrDefault(parent, new HashSet<Integer>());
                children.add(i);
                childrenMap.put(parent, children);
            }
        }
        if (targetPathLength < t) {
            Set<Integer> targetChildren = childrenMap.getOrDefault(target - 1, new HashSet<Integer>());
            if (targetChildren.size() > 0)
                return 0;
        }
        double probability = 1.0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            Set<Integer> children = childrenMap.getOrDefault(parent, new HashSet<Integer>());
            int childrenSize = children.size();
            if (childrenSize == 0)
                break;
            probability /= childrenSize;
            children.retainAll(targetPathSet);
            for (int child : children) {
                visited[child] = true;
                queue.offer(child);
            }
        }
        return probability;
    }
}