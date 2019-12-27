class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int begin = edge[0], end = edge[1];
            List<Integer> beginList = edgesMap.getOrDefault(begin, new ArrayList<Integer>());
            beginList.add(end);
            edgesMap.put(begin, beginList);
            List<Integer> endList = edgesMap.getOrDefault(end, new ArrayList<Integer>());
            endList.add(begin);
            edgesMap.put(end, endList);
        }
        boolean[] visited = new boolean[n];
        int componentsCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                breadthFirstSearch(i, visited, edgesMap);
                componentsCount++;
            }
        }
        return componentsCount;
    }

    public void breadthFirstSearch(int startNode, boolean[] visited, Map<Integer, List<Integer>> edgesMap) {
        visited[startNode] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(startNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> adjacentNodes = edgesMap.getOrDefault(node, new ArrayList<Integer>());
            for (int adjacentNode : adjacentNodes) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    queue.offer(adjacentNode);
                }
            }
        }
    }
}