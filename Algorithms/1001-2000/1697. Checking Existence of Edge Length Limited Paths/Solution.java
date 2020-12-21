class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int queriesCount = queries.length;
        Integer[] queryIndices = new Integer[queriesCount];
        for (int i = 0; i < queriesCount; i++)
            queryIndices[i] = i;
        Arrays.sort(queryIndices, new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return queries[index1][2] - queries[index2][2];
            }
        });
        Arrays.sort(edgeList, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        boolean[] exists = new boolean[queriesCount];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int index = 0;
        int edgesCount = edgeList.length;
        for (int i = 0; i < queriesCount; i++) {
            int queryIndex = queryIndices[i];
            int[] query = queries[queryIndex];
            int start = query[0], end = query[1];
            while (index < edgesCount && edgeList[index][2] < query[2]) {
                union(parent, edgeList[index][0], edgeList[index][1]);
                index++;
            }
            exists[queryIndex] = find(parent, start) == find(parent, end);
        }
        return exists;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index)
            parent[index] = find(parent, parent[index]);
        return parent[index];
    }
}