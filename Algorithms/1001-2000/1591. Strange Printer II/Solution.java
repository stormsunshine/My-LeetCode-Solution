class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, int[]> boundsMap = new HashMap<Integer, int[]>();
        int rows = targetGrid.length, columns = targetGrid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int color = targetGrid[i][j];
                if (!boundsMap.containsKey(color))
                    boundsMap.put(color, new int[]{i, i, j, j});
                else {
                    int[] bounds = boundsMap.get(color);
                    bounds[0] = Math.min(bounds[0], i);
                    bounds[1] = Math.max(bounds[1], i);
                    bounds[2] = Math.min(bounds[2], j);
                    bounds[3] = Math.max(bounds[3], j);
                    boundsMap.put(color, bounds);
                }
            }
        }
        Set<Integer> keySet = boundsMap.keySet();
        Map<Integer, List<Integer>> greaterMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int color = targetGrid[i][j];
                List<Integer> list = greaterMap.getOrDefault(color, new ArrayList<Integer>());
                for (int key : keySet) {
                    if (key != color) {
                        int[] bounds = boundsMap.get(key);
                        if (i >= bounds[0] && i <= bounds[1] && j >= bounds[2] && j <= bounds[3])
                            list.add(key);
                    }
                }
                greaterMap.put(color, list);
            }
        }
        Map<Integer, Integer> indegreeMap = new HashMap<Integer, Integer>();
        for (int color : keySet) {
            List<Integer> nextColors = greaterMap.getOrDefault(color, new ArrayList<Integer>());
            for (int nextColor : nextColors) {
                int indegree = indegreeMap.getOrDefault(nextColor, 0) + 1;
                indegreeMap.put(nextColor, indegree);
            }
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int color : keySet) {
            int indegree = indegreeMap.getOrDefault(color, 0);
            if (indegree == 0) {
                visited.add(color);
                queue.offer(color);
            }
        }
        while (!queue.isEmpty()) {
            int color = queue.poll();
            List<Integer> nextColors = greaterMap.getOrDefault(color, new ArrayList<Integer>());
            for (int nextColor : nextColors) {
                int indegree = indegreeMap.getOrDefault(nextColor, 0) - 1;
                if (indegree == 0) {
                    indegreeMap.remove(nextColor);
                    visited.add(nextColor);
                    queue.offer(nextColor);
                } else
                    indegreeMap.put(nextColor, indegree);
            }
        }
        return visited.size() == keySet.size();
    }
}