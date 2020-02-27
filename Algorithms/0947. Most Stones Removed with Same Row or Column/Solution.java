class Solution {
    public int removeStones(int[][] stones) {
        int length = stones.length;
        if (length <= 1)
            return 0;
        int[] parents = new int[20000];
        for (int i = 0; i < 20000; i++)
            parents[i] = i;
        for (int[] stone : stones)
            union(parents, stone[0], stone[1] + 10000);
        Set<Integer> set = new HashSet<Integer>();
        for (int[] stone : stones)
            set.add(findAncestor(parents, stone[0]));
        return length - set.size();

    }

    public void union(int[] parents, int row, int column) {
        int rowParent = findAncestor(parents, row), columnParent = findAncestor(parents, column);
        if (rowParent != columnParent)
            parents[rowParent] = columnParent;
    }

    public int findAncestor(int[] parents, int start) {
        int ancestor = start;
        int cur = start;
        while (ancestor != parents[ancestor])
            ancestor = parents[ancestor];
        while (cur != parents[cur]) {
            int curParent = parents[cur];
            parents[cur] = ancestor;
            cur = curParent;
        }
        return ancestor;
    }
}