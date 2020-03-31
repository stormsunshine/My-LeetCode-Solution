class Solution {
    public int[][] outerTrees(int[][] points) {
        int length = points.length;
        if (length < 4)
            return points;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[0] != point2[0])
                    return point1[0] - point2[0];
                else
                    return point1[1] - point2[1];
            }
        });
        List<int[]> hullList = new ArrayList<int[]>();
        Set<String> hullSet = new HashSet<String>();
        int p = 0;
        do {
            int q = (p + 1) % length;
            for (int i = 0; i < length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0)
                    q = i;
            }
            for (int i = 0; i < length; i++) {
                if (i == p || i == q)
                    continue;
                if (orientation(points[p], points[i], points[q]) == 0 && isBetween(points[i], points[p], points[q])) {
                    if (hullSet.add(Arrays.toString(points[i])))
                        hullList.add(points[i]);
                }
            }
            if (hullSet.add(Arrays.toString(points[q])))
                hullList.add(points[q]);
            p = q;
        } while (p != 0);
        int hullLength = hullList.size();
        int[][] hullArray = new int[hullLength][2];
        for (int i = 0; i < hullLength; i++) {
            int[] hull = hullList.get(i);
            for (int j = 0; j < 2; j++)
                hullArray[i][j] = hull[j];
        }
        return hullArray;
    }

    public int orientation(int[] point1, int[] point2, int[] point3) {
        return (point2[0] - point1[0]) * (point3[1] - point2[1]) - (point3[0] - point2[0]) * (point2[1] - point1[1]);
    }

    public boolean isBetween(int[] point, int[] point1, int[] point2) {
        boolean xBetween = point[0] >= point1[0] && point[0] <= point2[0] || point[0] <= point1[0] && point[0] >= point2[0];
        boolean yBetween = point[1] >= point1[1] && point[1] <= point2[1] || point[1] <= point1[1] && point[1] >= point2[1];
        return xBetween && yBetween;
    }
}