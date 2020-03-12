class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        int[][] closestPoints = new int[K][2];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 2; j++)
                closestPoints[i][j] = points[i][j];
        }
        return closestPoints;
    }
}