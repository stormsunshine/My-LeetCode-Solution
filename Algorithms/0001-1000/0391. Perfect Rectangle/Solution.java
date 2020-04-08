class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int xMin = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        Set<String> set = new HashSet<String>();
        int area = 0;
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            xMin = Math.min(xMin, x1);
            yMin = Math.min(yMin, y1);
            xMax = Math.max(xMax, x2);
            yMax = Math.max(yMax, y2);
            area += (x2 - x1) * (y2 - y1);
            int[][] points = {{x1, y1}, {x1, y2}, {x2, y1}, {x2, y2}};
            for (int[] point : points) {
                String pointStr = Arrays.toString(point);
                if (!set.add(pointStr))
                    set.remove(pointStr);
            }
        }
        if (set.size() != 4)
            return false;
        int[][] corners = {{xMin, yMin}, {xMin, yMax}, {xMax, yMin}, {xMax, yMax}};
        for (int[] corner : corners) {
            String cornerStr = Arrays.toString(corner);
            if (!set.contains(cornerStr))
                return false;
        }
        return (xMax - xMin) * (yMax - yMin) == area;
    }
}