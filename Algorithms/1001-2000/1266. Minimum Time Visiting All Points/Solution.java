class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int length = points.length;
        for (int i = 1; i < length; i++) {
            int[] prevPoint = points[i - 1];
            int[] curPoint = points[i];
            int curTime = Math.max(Math.abs(curPoint[0] - prevPoint[0]), Math.abs(curPoint[1] - prevPoint[1]));
            time += curTime;
        }
        return time;
    }
}