class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] redundantConnection = new int[2];
        Map<Integer, Integer> nodeGroupMap = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>> groupNodesMap = new HashMap<Integer, Set<Integer>>();
        int nodesCount = edges.length;
        for (int i = 1; i <= nodesCount; i++) {
            nodeGroupMap.put(i, i);
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            groupNodesMap.put(i, set);
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            int group1 = nodeGroupMap.getOrDefault(node1, node1);
            int group2 = nodeGroupMap.getOrDefault(node2, node2);
            if (group1 == group2) {
                redundantConnection[0] = node1;
                redundantConnection[1] = node2;
                break;
            } else {
                Set<Integer> set1 = groupNodesMap.getOrDefault(group1, new HashSet<Integer>());
                Set<Integer> set2 = groupNodesMap.getOrDefault(group2, new HashSet<Integer>());
                if (group1 < group2) {
                    set1.addAll(set2);
                    for (int node : set2)
                        nodeGroupMap.put(node, group1);
                    groupNodesMap.put(group1, set1);
                } else {
                    set2.addAll(set1);
                    for (int node : set1)
                        nodeGroupMap.put(node, group2);
                    groupNodesMap.put(group2, set2);
                }
            }
        }
        return redundantConnection;
    }
}