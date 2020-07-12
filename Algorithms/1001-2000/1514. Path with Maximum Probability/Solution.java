class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Double>> probabilitiesMap = new HashMap<Integer, List<Double>>();
        int edgesCount = edges.length;
        for (int i = 0; i < edgesCount; i++) {
            int[] edge = edges[i];
            double probability = succProb[i];
            int node0 = edge[0], node1 = edge[1];
            List<Integer> edgeList0 = edgesMap.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> edgeList1 = edgesMap.getOrDefault(node1, new ArrayList<Integer>());
            List<Double> probabilityList0 = probabilitiesMap.getOrDefault(node0, new ArrayList<Double>());
            List<Double> probabilityList1 = probabilitiesMap.getOrDefault(node1, new ArrayList<Double>());
            edgeList0.add(node1);
            edgeList1.add(node0);
            probabilityList0.add(probability);
            probabilityList1.add(probability);
            edgesMap.put(node0, edgeList0);
            edgesMap.put(node1, edgeList1);
            probabilitiesMap.put(node0, probabilityList0);
            probabilitiesMap.put(node1, probabilityList1);
        }
        double[] probabilities = new double[n];
        probabilities[start] = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            double probability = probabilities[node];
            List<Integer> edgeList = edgesMap.getOrDefault(node, new ArrayList<Integer>());
            List<Double> probabilityList = probabilitiesMap.getOrDefault(node, new ArrayList<Double>());
            int size = edgeList.size();
            for (int i = 0; i < size; i++) {
                int nextNode = edgeList.get(i);
                double nextProbability = probability * probabilityList.get(i);
                if (nextProbability > probabilities[nextNode]) {
                    probabilities[nextNode] = nextProbability;
                    queue.offer(nextNode);
                }
            }
        }
        return probabilities[end];
    }
}