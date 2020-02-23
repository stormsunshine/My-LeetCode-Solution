class Solution {
    public int treeDiameter(int[][] edges) {
        int nodes = edges.length + 1;
        int[] degrees = new int[nodes];
        Set<Integer>[] connects = new Set[nodes];
        for (int i = 0; i < nodes; i++)
            connects[i] = new HashSet<Integer>();
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            degrees[node1]++;
            degrees[node2]++;
            connects[node1].add(node2);
            connects[node2].add(node1);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nodes; i++) {
            if (degrees[i] == 1)
                queue.offer(i);
        }
        int depth = 0;
        int remaining = nodes;
        while (!queue.isEmpty() && remaining > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                degrees[node]--;
                Set<Integer> connectSet = connects[node];
                for (int connect : connectSet) {
                    degrees[connect]--;
                    if (degrees[connect] == 1)
                        queue.offer(connect);
                }
            }
            remaining -= size;
            depth++;
        }
        return remaining == 2 ? 2 * depth + 1 : 2 * depth;
    }
}