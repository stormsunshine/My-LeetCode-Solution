class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int edgesCount = edges.length;
        int[] diametersCounts = new int[edgesCount];
        int combinationsCount = 1 << edgesCount;
        for (int i = 1; i < combinationsCount; i++) {
            boolean[] combination = getCombination(edgesCount, i);
            List<int[]> selectedEdges = new ArrayList<int[]>();
            for (int j = 0; j < edgesCount; j++) {
                if (combination[j])
                    selectedEdges.add(edges[j]);
            }
            int diameter = diameter(n, selectedEdges);
            if (diameter > 0)
                diametersCounts[diameter - 1]++;
        }
        return diametersCounts;
    }

    public boolean[] getCombination(int length, int index) {
        boolean[] combination = new boolean[length];
        for (int i = 0; i < length && index > 0; i++) {
            combination[i] = index % 2 == 1;
            index >>= 1;
        }
        return combination;
    }

    public int diameter(int n, List<int[]> edges) {
        int[] degrees = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0] - 1, node1 = edge[1] - 1;
            degrees[node0]++;
            degrees[node1]++;
            List<Integer> list0 = map.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> list1 = map.getOrDefault(node1, new ArrayList<Integer>());
            list0.add(node1);
            list1.add(node0);
            map.put(node0, list0);
            map.put(node1, list1);
        }
        if (map.size() != edges.size() + 1)
            return 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1)
                queue.offer(i);
        }
        int depth = 0;
        int remaining = map.size();
        while (!queue.isEmpty() && remaining > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                degrees[node]--;
                List<Integer> list = map.getOrDefault(node, new ArrayList<Integer>());
                for (int nextNode : list) {
                    degrees[nextNode]--;
                    if (degrees[nextNode] == 1)
                        queue.offer(nextNode);
                }
            }
            remaining -= size;
            depth++;
        }
        return remaining == 2 ? 2 * depth + 1 : 2 * depth;
    }
}