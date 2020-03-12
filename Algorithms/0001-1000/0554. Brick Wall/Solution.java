class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> row : wall) {
            int curWidth = 0;
            int size = row.size() - 1;
            for (int i = 0; i < size; i++) {
                int width = row.get(i);
                curWidth += width;
                int count = map.getOrDefault(curWidth, 0);
                count++;
                map.put(curWidth, count);
            }
        }
        int maxEdges = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            int count = map.getOrDefault(key, 0);
            maxEdges = Math.max(maxEdges, count);
        }
        int minCrossBricks = wall.size() - maxEdges;
        return minCrossBricks;
    }
}