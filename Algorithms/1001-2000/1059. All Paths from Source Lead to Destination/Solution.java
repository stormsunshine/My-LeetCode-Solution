class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            List<Integer> endList = edgesMap.getOrDefault(start, new ArrayList<Integer>());
            endList.add(end);
            edgesMap.put(start, endList);
        }
        int maxStep = n;
        Set<Integer> finalNodesSet = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        while (!queue.isEmpty() && maxStep > 0) {
            Set<Integer> nextSet = new HashSet<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextNodes = edgesMap.getOrDefault(node, new ArrayList<Integer>());
                if (nextNodes.size() == 0) {
                    if (node != destination)
                        return false;
                    finalNodesSet.add(node);
                } else {
                    for (int nextNode : nextNodes)
                        nextSet.add(nextNode);
                }
            }
            for (int nextNode : nextSet)
                queue.offer(nextNode);
            maxStep--;
        }
        List<Integer> finalNodes = new ArrayList<Integer>();
        for (int node : finalNodesSet)
            finalNodes.add(node);
        return queue.isEmpty() && finalNodes.size() == 1 && finalNodes.get(0) == destination;
    }
}