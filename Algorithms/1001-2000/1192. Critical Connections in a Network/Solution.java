class Solution {
    int[] times;
    int[] roots;
    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        times = new int[n];
        roots = new int[n];
        time = 0;
        Arrays.fill(times, -1);
        Arrays.fill(roots, -1);
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (List<Integer> connection : connections) {
            int node1 = connection.get(0), node2 = connection.get(1);
            List<Integer> list1 = edgesMap.getOrDefault(node1, new ArrayList<Integer>());
            List<Integer> list2 = edgesMap.getOrDefault(node2, new ArrayList<Integer>());
            list1.add(node2);
            list2.add(node1);
            edgesMap.put(node1, list1);
            edgesMap.put(node2, list2);
        }
        List<List<Integer>> criticalConnections = new ArrayList<List<Integer>>();
        depthFirstSearch(edgesMap, 0, criticalConnections, -1);
        return criticalConnections;
    }

    public void depthFirstSearch(Map<Integer, List<Integer>> edgesMap, int node, List<List<Integer>> criticalConnections, int parent) {
        times[node] = time;
        roots[node] = time;
        time++;
        List<Integer> adjacentList = edgesMap.getOrDefault(node, new ArrayList<Integer>());
        for (int adjacentNode : adjacentList) {
            if (adjacentNode == parent)
                continue;
            if (times[adjacentNode] == -1) {
                depthFirstSearch(edgesMap, adjacentNode, criticalConnections, node);
                roots[node] = Math.min(roots[node], roots[adjacentNode]);
                if (roots[adjacentNode] > times[node])
                    criticalConnections.add(Arrays.asList(node, adjacentNode));
            } else
                roots[node] = Math.min(roots[node], times[adjacentNode]);
        }
    }
}