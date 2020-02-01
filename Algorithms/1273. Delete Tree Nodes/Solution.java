class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> parentChildrenMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nodes; i++) {
            int parentIndex = parent[i];
            if (parentIndex >= 0) {
                List<Integer> children = parentChildrenMap.getOrDefault(parentIndex, new ArrayList<Integer>());
                children.add(i);
                parentChildrenMap.put(parentIndex, children);
            }
        }
        List<Integer> nodesList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesList.add(node);
            List<Integer> children = parentChildrenMap.getOrDefault(node, new ArrayList<Integer>());
            for (int child : children)
                queue.offer(child);
        }
        List<Integer> deleteNodesList = new ArrayList<Integer>();
        for (int i = nodes - 1; i >= 0; i--) {
            int node = nodesList.get(i);
            int parentIndex = parent[node];
            if (value[node] == 0)
                deleteNodesList.add(node);
            else if (parentIndex >= 0)
                value[parentIndex] += value[node];
        }
        Set<Integer> deleteNodesSet = new HashSet<Integer>();
        Queue<Integer> deleteQueue = new LinkedList<Integer>();
        for (int i = deleteNodesList.size() - 1; i >= 0; i--)
            deleteQueue.offer(deleteNodesList.get(i));
        while (!deleteQueue.isEmpty()) {
            int node = deleteQueue.poll();
            if (deleteNodesSet.add(node)) {
                List<Integer> children = parentChildrenMap.getOrDefault(node, new ArrayList<Integer>());
                for (int child : children)
                    deleteQueue.offer(child);
            }
        }
        return nodes - deleteNodesSet.size();
    }
}