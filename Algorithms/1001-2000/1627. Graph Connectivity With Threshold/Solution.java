class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parents[i] = i;
        int max = n / 2;
        for (int i = threshold + 1; i <= max; i++) {
            for (int j = i * 2; j <= n; j += i)
                union(parents, i, j);
        }
        List<Boolean> list = new ArrayList<Boolean>();
        for (int[] query : queries)
            list.add(find(parents, query[0]) == find(parents, query[1]));
        return list;
    }

    public void union(int[] parents, int index1, int index2) {
        parents[find(parents, index1)] = find(parents, index2);
    }

    public int find(int[] parents, int index) {
        while (parents[index] != index) {
            parents[index] = find(parents, parents[index]);
            index = parents[index];
        }
        return index;
    }
}