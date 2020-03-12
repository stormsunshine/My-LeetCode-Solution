class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rootList = new ArrayList<Integer>();
        if (n == 0)
            return rootList;
        if (n == 1) {
            rootList.add(0);
            return rootList;
        }
        int[] degrees = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            degrees[node1]++;
            degrees[node2]++;
            List<Integer> list1 = map.getOrDefault(node1, new ArrayList<Integer>());
            List<Integer> list2 = map.getOrDefault(node2, new ArrayList<Integer>());
            list1.add(node2);
            list2.add(node1);
            map.put(node1, list1);
            map.put(node2, list2);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            rootList.clear();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                rootList.add(node);
                List<Integer> adjacentList = map.getOrDefault(node, new ArrayList<Integer>());
                for (int adjacentNode : adjacentList) {
                    degrees[adjacentNode]--;
                    if (degrees[adjacentNode] == 1)
                        queue.offer(adjacentNode);
                }
            }
        }
        return rootList;
    }
}