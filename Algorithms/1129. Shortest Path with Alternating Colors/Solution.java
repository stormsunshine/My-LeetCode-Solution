class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>> redEdgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] redEdge : red_edges) {
            int src = redEdge[0], dst = redEdge[1];
            List<Integer> dstList = redEdgesMap.getOrDefault(src, new ArrayList<Integer>());
            dstList.add(dst);
            redEdgesMap.put(src, dstList);
        }
        Map<Integer, List<Integer>> blueEdgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] blueEdge : blue_edges) {
            int src = blueEdge[0], dst = blueEdge[1];
            List<Integer> dstList = blueEdgesMap.getOrDefault(src, new ArrayList<Integer>());
            dstList.add(dst);
            blueEdgesMap.put(src, dstList);
        }
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        final int RED = 0;
        final int BLUE = 1;
        int[][] colors = new int[n][4];
        int[][] distances = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++)
                distances[i][j] = Integer.MAX_VALUE;
        }
        colors[0][0] = GRAY;
        colors[0][3] = GRAY;
        distances[0][0] = 0;
        distances[0][3] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < 2; i++)
            queue.offer(new int[]{0, i, i});
        while (!queue.isEmpty()) {
            int[] indexPath = queue.poll();
            int index = indexPath[0], startPath = indexPath[1], path = indexPath[2];
            int distance = distances[index][startPath * 2 + path];
            List<Integer> nextNodes = path == RED ? redEdgesMap.getOrDefault(index, new ArrayList<Integer>()) : blueEdgesMap.getOrDefault(index, new ArrayList<Integer>());
            int nextPath = RED + BLUE - path;
            for (int nextNode : nextNodes) {
                if (colors[nextNode][startPath * 2 + nextPath] == WHITE) {
                    colors[nextNode][startPath * 2 + nextPath] = GRAY;
                    distances[nextNode][startPath * 2 + nextPath] = distance + 1;
                    queue.offer(new int[]{nextNode, startPath, nextPath});
                }
            }
            colors[index][startPath * 2 + path] = BLACK;
        }
        int[] shortestDistances = new int[n];
        for (int i = 0; i < n; i++) {
            int shortestDistance = Integer.MAX_VALUE;
            for (int j = 0; j < 4; j++)
                shortestDistance = Math.min(shortestDistance, distances[i][j]);
            shortestDistances[i] = shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
        }
        return shortestDistances;
    }
}