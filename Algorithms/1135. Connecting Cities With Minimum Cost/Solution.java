class Solution {
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, new Comparator<int[]>() {
            public int compare(int[] connection1, int[] connection2) {
                return connection1[2] - connection2[2];
            }
        });
        Map<Integer, Integer> nodeGroupMap = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> groupNodesMap = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= N; i++) {
            nodeGroupMap.put(i, i);
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            groupNodesMap.put(i, list);
        }
        int edges = 0;
        int totalCost = 0;
        int connectionsCount = connections.length;
        for (int i = 0; i < connectionsCount; i++) {
            int[] connection = connections[i];
            int city1 = connection[0], city2 = connection[1], cost = connection[2];
            if (city1 > city2) {
                int temp = city1;
                city1 = city2;
                city2 = temp;
            }
            int group1 = nodeGroupMap.get(city1), group2 = nodeGroupMap.get(city2);
            if (group1 != group2) {
                List<Integer> list1 = groupNodesMap.getOrDefault(group1, new ArrayList<Integer>());
                List<Integer> list2 = groupNodesMap.getOrDefault(group2, new ArrayList<Integer>());
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
                edges++;
                totalCost += cost;
            }
        }
        return edges == N - 1 ? totalCost : -1;
    }
}