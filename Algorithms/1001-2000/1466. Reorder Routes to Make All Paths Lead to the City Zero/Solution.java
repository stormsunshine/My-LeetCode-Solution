class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<Integer, Set<Integer>>();
        for (int[] connection : connections) {
            int node0 = connection[0], node1 = connection[1];
            Set<Integer> set0 = edgeMap.getOrDefault(node0, new HashSet<Integer>());
            Set<Integer> set1 = edgeMap.getOrDefault(node1, new HashSet<Integer>());
            set0.add(node1);
            set1.add(node0);
            edgeMap.put(node0, set0);
            edgeMap.put(node1, set1);
        }
        Map<Integer, Integer> nodeLevelMap = new HashMap<Integer, Integer>();
        nodeLevelMap.put(0, 0);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int level = nodeLevelMap.get(node);
            int nextLevel = level + 1;
            Set<Integer> set = edgeMap.getOrDefault(node, new HashSet<Integer>());
            for (int nextNode : set) {
                if (!nodeLevelMap.containsKey(nextNode)) {
                    nodeLevelMap.put(nextNode, nextLevel);
                    queue.offer(nextNode);
                }
            }
        }
        int reorderCount = 0;
        for (int[] connection : connections) {
            int node0 = connection[0], node1 = connection[1];
            int level0 = nodeLevelMap.get(node0), level1 = nodeLevelMap.get(node1);
            if (level0 < level1)
                reorderCount++;
        }
        return reorderCount;
    }
}