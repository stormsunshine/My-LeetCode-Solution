class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int queriesCount = queries.length;
        int[] counts = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int[] query = queries[i];
            int x = query[0], y = query[1], r = query[2];
            int rSquare = r * r;
            for (int[] point : points) {
                int distanceSquare = getDistanceSquare(point, x, y);
                if (distanceSquare <= rSquare)
                    counts[i]++;
            }
        }
        return counts;
    }

    public int getDistanceSquare(int[] point, int x, int y) {
        return (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]);
    }
}