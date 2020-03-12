class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int numOfPoints = points.length;
        for (int i = 0; i < numOfPoints; i++) {
            map.clear();
            int[] point1 = points[i];
            for (int j = 0; j < numOfPoints; j++) {
                if (i == j)
                    continue;
                int[] point2 = points[j];
                int distanceSquare = distanceSquare(point1, point2);
                int distanceCount = map.getOrDefault(distanceSquare, 0);
                distanceCount++;
                map.put(distanceSquare, distanceCount);
            }
            Set<Integer> keySet = map.keySet();
            for (int key : keySet) {
                int distanceCount = map.get(key);
                count += distanceCount * (distanceCount - 1);
            }
        }
        return count;
    }

    public int distanceSquare(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}