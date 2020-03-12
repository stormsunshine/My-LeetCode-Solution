class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPathsList = new ArrayList<List<Integer>>();
        int nodes = graph.length;
        int target = nodes - 1;
        Queue<Integer> nodesQueue = new LinkedList<Integer>();
        Queue<List<Integer>> pathsQueue = new LinkedList<List<Integer>>();
        nodesQueue.offer(0);
        List<Integer> initialList = new ArrayList<Integer>();
        initialList.add(0);
        pathsQueue.offer(initialList);
        while (!nodesQueue.isEmpty()) {
            int node = nodesQueue.poll();
            List<Integer> prevPath = pathsQueue.poll();
            int[] nextNodes = graph[node];
            for (int nextNode : nextNodes) {
                List<Integer> curPath = new ArrayList<Integer>(prevPath);
                curPath.add(nextNode);
                if (nextNode == target)
                    allPathsList.add(curPath);
                else {
                    nodesQueue.offer(nextNode);
                    pathsQueue.offer(curPath);
                }
            }
        }
        return allPathsList;
    }
}