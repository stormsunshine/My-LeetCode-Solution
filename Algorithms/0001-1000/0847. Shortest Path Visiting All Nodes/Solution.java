class Solution {
    public int shortestPathLength(int[][] graph) {
        int nodes = graph.length;
        int totalStates = 1 << nodes;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] distances = new int[totalStates][nodes];
        for (int i = 0; i < totalStates; i++) {
            for (int j = 0; j < nodes; j++)
                distances[i][j] = nodes * nodes;
        }
        for (int i = 0; i < nodes; i++) {
            queue.offer(new int[]{1 << i, i});
            distances[1 << i][i] = 0;
        }
        int minDistance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int distance = distances[state[0]][state[1]];
            if (state[0] == (1 << nodes) - 1) {
                minDistance = distance;
                break;
            }
            int[] children = graph[state[1]];
            for (int child : children) {
                int nextNodes = state[0] | (1 << child);
                if (distances[nextNodes][child] > distance + 1) {
                    distances[nextNodes][child] = distance + 1;
                    queue.offer(new int[]{nextNodes, child});
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}