class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int distance = manhattanDistance(x, y, point);
                if (distance < minDistance) {
                    minIndex = i;
                    minDistance = distance;
                }
            }
        }
        return minIndex;
    }

    public int manhattanDistance(int x, int y, int[] point) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }
}