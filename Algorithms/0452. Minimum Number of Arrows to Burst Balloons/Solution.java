class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[0] != point2[0])
                    return point1[0] - point2[0];
                else
                    return point1[1] - point2[1];
            }
        });
        int arrows = 0;
        int left = points[0][0], right = points[0][1];
        int length = points.length;
        for (int i = 1; i < length; i++) {
            int[] point = points[i];
            if (point[0] > right) {
                arrows++;
                left = point[0];
                right = point[1];
            } else {
                left = Math.max(left, point[0]);
                right = Math.min(right, point[1]);
            }
        }
        arrows++;
        return arrows;
    }
}