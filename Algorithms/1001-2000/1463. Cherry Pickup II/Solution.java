class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        Set<Integer> visitedSet = new HashSet<Integer>();
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{columns - 1, grid[0][0] + grid[0][columns - 1]});
        for (int i = 1; i < rows; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] array = queue.poll();
                int positions = array[0], cherries = array[1];
                int position0 = positions / columns, position1 = positions % columns;
                for (int k = position0 - 1; k <= position0 + 1; k++) {
                    if (k < 0 || k >= columns)
                        continue;
                    for (int m = Math.max(k + 1, position1 - 1); m <= position1 + 1; m++) {
                        if (m < 0 || m >= columns)
                            continue;
                        int newPosition = k * columns + m;
                        int newCherries = k == m ? cherries + grid[i][k] : cherries + grid[i][k] + grid[i][m];
                        int max = Math.max(map.getOrDefault(newPosition, 0), newCherries);
                        map.put(newPosition, max);
                    }
                }
            }
            Set<Integer> keySet = map.keySet();
            for (int newPosition : keySet)
                queue.offer(new int[]{newPosition, map.get(newPosition)});
        }
        int maxCherries = 0;
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            maxCherries = Math.max(maxCherries, array[1]);
        }
        return maxCherries;
    }
}