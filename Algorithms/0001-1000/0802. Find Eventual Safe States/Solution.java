class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        boolean[] safe = new boolean[nodes];
        List<Set<Integer>> nextNodes = new ArrayList<Set<Integer>>();
        List<Set<Integer>> prevNodes = new ArrayList<Set<Integer>>();
        for (int i = 0; i < nodes; i++) {
            nextNodes.add(new HashSet<Integer>());
            prevNodes.add(new HashSet<Integer>());
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nodes; i++) {
            int[] nextArray = graph[i];
            if (nextArray.length == 0)
                queue.offer(i);
            else {
                for (int nextNode : nextArray) {
                    nextNodes.get(i).add(nextNode);
                    prevNodes.get(nextNode).add(i);
                }
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            Set<Integer> prevSet = prevNodes.get(node);
            for (int prevNode : prevSet) {
                nextNodes.get(prevNode).remove(node);
                if (nextNodes.get(prevNode).isEmpty())
                    queue.offer(prevNode);
            }
        }
        List<Integer> safeList = new ArrayList<Integer>();
        for (int i = 0; i < nodes; i++) {
            if (safe[i])
                safeList.add(i);
        }
        return safeList;
    }
}