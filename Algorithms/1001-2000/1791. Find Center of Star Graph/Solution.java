class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] connections = new int[n + 1];
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            connections[node1]++;
            connections[node2]++;
            if (connections[node1] > 1)
                return node1;
            else if (connections[node2] > 1)
                return node2;
        }
        return 0;
    }
}