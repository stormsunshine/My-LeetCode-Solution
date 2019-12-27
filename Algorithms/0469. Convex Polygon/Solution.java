class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int edgesCount = points.size();
        if (edgesCount < 3)
            return false;
        long cur = 0, pre = 0;
        for (int i = 0; i < edgesCount; i++) {
            int x1 = points.get((i + 1) % edgesCount).get(0) - points.get(i).get(0);
            int x2 = points.get((i + 2) % edgesCount).get(0) - points.get(i).get(0);
            int y1 = points.get((i + 1) % edgesCount).get(1) - points.get(i).get(1);
            int y2 = points.get((i + 2) % edgesCount).get(1) - points.get(i).get(1);
            cur = x1 * y2 - x2 * y1;
            if (cur != 0 && cur * pre < 0)
                return false;
            if (cur != 0)
                pre = cur;
        }
        return true;
    }
    
}