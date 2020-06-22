class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int edgesCount = edges.length;
        List<Integer> indicesList = new ArrayList<Integer>();
        for (int i = 0; i < edgesCount; i++)
            indicesList.add(i);
        Collections.sort(indicesList, new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return edges[index1][2] - edges[index2][2];
            }
        });
        int minCost = minimumSpanningTreeKruskal(n, indicesList, edges, -1, false);
        List<List<Integer>> criticalEdges = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; i++)
            criticalEdges.add(new ArrayList<Integer>());
        for (int i = 0; i < edgesCount; i++) {
            if (minimumSpanningTreeKruskal(n, indicesList, edges, i, true) == minCost) {
                if (minimumSpanningTreeKruskal(n, indicesList, edges, i, false) > minCost)
                    criticalEdges.get(0).add(i);
                else
                    criticalEdges.get(1).add(i);
            }
        }
        return criticalEdges;
    }

    public int minimumSpanningTreeKruskal(int n, List<Integer> indicesList, int[][] edges, int key, boolean flag) {
        int minCost = flag ? edges[key][2] : 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        if (flag)
            parent[edges[key][0]] = edges[key][1];
        int edgesCount = edges.length;
        for (int i = 0; i < edgesCount; i++) {
            if (indicesList.get(i) != key) {
                int parent0 = find(parent, edges[indicesList.get(i)][0]);
                int parent1 = find(parent, edges[indicesList.get(i)][1]);
                if (parent0 != parent1) {
                    parent[parent0] = parent1;
                    minCost += edges[indicesList.get(i)][2];
                }
            }
        }
        int first = find(parent, 0);
        for (int i = 1; i < n; i++) {
            if (find(parent, i) != first)
                return Integer.MAX_VALUE;
        }
        return minCost;
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}