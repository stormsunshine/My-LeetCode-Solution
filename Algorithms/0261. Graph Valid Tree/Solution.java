class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null)
            return n == 1;
        int edgesCount = edges.length;
        if (edgesCount != n - 1)
            return false;
        for (int[] edge : edges)
            Arrays.sort(edge);
        Arrays.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                if (edge1[0] != edge2[0])
                    return edge1[0] - edge2[0];
                else
                    return edge1[1] - edge2[1];
            }
        });
        Map<Integer, Integer> nodeGroupMap = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> groupNodesMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            nodeGroupMap.put(i, i);
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            groupNodesMap.put(i, list);
        }
        for (int i = 0; i < edgesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            int group1 = nodeGroupMap.get(node1), group2 = nodeGroupMap.get(node2);
            if (group1 == group2)
                continue;
            List<Integer> list1 = groupNodesMap.get(group1);
            List<Integer> list2 = groupNodesMap.get(group2);
            if (group1 < group2) {
                for (int node : list2)
                    nodeGroupMap.put(node, group1);
                list1.addAll(list2);
                groupNodesMap.put(group1, list1);
                groupNodesMap.remove(group2);
            } else {
                for (int node : list1)
                    nodeGroupMap.put(node, group2);
                list2.addAll(list1);
                groupNodesMap.put(group2, list2);
                groupNodesMap.remove(group1);
            }
        }
        return groupNodesMap.keySet().size() == 1;
    }
}