class Solution {
    int[] parents1;
    int[] parents2;
    int[] parents3;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parents1 = new int[n + 1];
        parents2 = new int[n + 1];
        parents3 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents1[i] = i;
            parents2[i] = i;
            parents3[i] = i;
        }
        int count = 0, count1 = 0, count2 = 0;
        for (int[] edge : edges) {
            int type = edge[0], node1 = edge[1], node2 = edge[2];
            if (type == 3) {
                int root1 = find(parents3, node1);
                int root2 = find(parents3, node2);
                if (root1 != root2) {
                    parents3[root1] = root2;
                    count++;
                    count1++;
                    count2++;
                    root1 = find(parents1, node1);
                    root2 = find(parents1, node2);
                    parents1[root1] = root2;
                    root1 = find(parents2, node1);
                    root2 = find(parents2, node2);
                    parents2[root1] = root2;
                }
            }
        }
        for (int[] edge : edges) {
            int type = edge[0], node1 = edge[1], node2 = edge[2];
            if (type == 1) {
                int root1 = find(parents1, node1);
                int root2 = find(parents1, node2);
                if (root1 != root2) {
                    count++;
                    count1++;
                    parents1[root1] = root2;
                }
            } else if (type == 2) {
                int root1 = find(parents2, node1);
                int root2 = find(parents2, node2);
                if (root1 != root2) {
                    count++;
                    count2++;
                    parents2[root1] = root2;
                }
            }
        }
        if (count1 != n - 1 || count2 != n - 1)
            return -1;
        return edges.length - count;
    }

    public int find(int[] parents, int index) {
        if (parents[index] == index)
            return index;
        else {
            parents[index] = find(parents, parents[index]);
            return parents[index];
        }
    }
}