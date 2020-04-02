class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Map<Integer, Set<Integer>> edgesMap = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            Set<Integer> set1 = edgesMap.getOrDefault(node1, new HashSet<Integer>());
            Set<Integer> set2 = edgesMap.getOrDefault(node2, new HashSet<Integer>());
            set1.add(node2);
            set2.add(node1);
            edgesMap.put(node1, set1);
            edgesMap.put(node2, set2);
        }
        int[] counts = new int[N];
        Arrays.fill(counts, 1);
        int[] sums = new int[N];
        depthFirstSearch1(0, -1, edgesMap, counts, sums);
        depthFirstSearch2(0, -1, edgesMap, counts, sums, N);
        return sums;
    }

    public void depthFirstSearch1(int node, int parent, Map<Integer, Set<Integer>> edgesMap, int[] counts, int[] sums) {
        Set<Integer> children = edgesMap.getOrDefault(node, new HashSet<Integer>());
        for (int child : children) {
            if (child != parent) {
                depthFirstSearch1(child, node, edgesMap, counts, sums);
                counts[node] += counts[child];
                sums[node] += sums[child] + counts[child];
            }
        }
    }

    public void depthFirstSearch2(int node, int parent, Map<Integer, Set<Integer>> edgesMap, int[] counts, int[] sums, int length) {
        Set<Integer> children = edgesMap.getOrDefault(node, new HashSet<Integer>());
        for (int child : children) {
            if (child != parent) {
                sums[child] = sums[node] - counts[child] + length - counts[child];
                depthFirstSearch2(child, node, edgesMap, counts, sums, length);
            }
        }
    }
}