class DistanceLimitedPathsExist {
    int n;
    int bits;
    UnionFind uf;
    int[][] edgeList;
    Map<Integer, List<int[]>> mstEdges;
    int[][] parent;
    int[][] maxWeights;
    int[] depths;
    boolean[] visited;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        this.n = n;
        this.uf = new UnionFind(n);
        this.edgeList = edgeList;
        Arrays.sort(this.edgeList, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        mstEdges = new HashMap<Integer, List<int[]>>();
        bits = (int) (Math.log(n) / Math.log(2)) + 2;
        this.parent = new int[n][bits];
        for (int i = 0; i < n; i++)
            Arrays.fill(this.parent[i], -1);
        this.maxWeights = new int[n][bits];
        this.depths = new int[n];
        this.visited = new boolean[n];
        kruskal();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depths[i] = 1;
                depthFirstSearch(i);
                parent[i][0] = i;
            }
        }
        for (int i = 1; i < bits; i++) {
            for (int j = 0; j < n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                maxWeights[j][i] = Math.max(maxWeights[j][i - 1], maxWeights[parent[j][i - 1]][i - 1]);
            }
        }
    }
    
    public boolean query(int p, int q, int limit) {
        if (uf.find(p) != uf.find(q))
            return false;
        else
            return lowestCommonAncestor(p, q) < limit;
    }

    private void kruskal() {
        int edgesCount = edgeList.length;
        for (int i = 0; i < edgesCount; i++) {
            int[] edge = edgeList[i];
            int u = edge[0], v = edge[1], dist = edge[2];
            if (uf.union(u, v)) {
                List<int[]> list1 = mstEdges.getOrDefault(u, new ArrayList<int[]>());
                List<int[]> list2 = mstEdges.getOrDefault(v, new ArrayList<int[]>());
                list1.add(new int[]{v, dist});
                list2.add(new int[]{u, dist});
                mstEdges.put(u, list1);
                mstEdges.put(v, list2);
            }
        }
    }

    private void depthFirstSearch(int u) {
        visited[u] = true;
        List<int[]> list = mstEdges.getOrDefault(u, new ArrayList<int[]>());
        for (int[] array : list) {
            int v = array[0], dist = array[1];
            if (!visited[v]) {
                depths[v] = depths[u] + 1;
                parent[v][0] = u;
                maxWeights[v][0] = dist;
                depthFirstSearch(v);
            }
        }
    }

    private int lowestCommonAncestor(int u, int v) {
        if (depths[u] > depths[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int temp = depths[v] - depths[u];
        int weight = 0;
        int index = 0;
        while (temp != 0) {
            if (temp % 2 != 0) {
                weight = Math.max(weight, maxWeights[v][index]);
                v = parent[v][index];
            }
            temp >>= 1;
            index++;
        }
        if (u == v)
            return weight;
        for (int i = bits - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                weight = Math.max(weight, Math.max(maxWeights[u][i], maxWeights[v][i]));
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        weight = Math.max(weight, Math.max(maxWeights[u][0], maxWeights[v][0]));
        return weight;
    }
}

class UnionFind {
    int n;
    int[] parent;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }

    public boolean union(int index1, int index2) {
        int ancestor1 = find(index1), ancestor2 = find(index2);
        if (ancestor1 == ancestor2)
            return false;
        else {
            parent[find(index2)] = find(index1);
            return true;
        }
    }

    public int find(int index) {
        if (parent[index] != index)
            parent[index] = find(parent[index]);
        return parent[index];
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */