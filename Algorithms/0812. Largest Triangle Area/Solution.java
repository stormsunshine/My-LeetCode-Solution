class Solution {
    public double largestTriangleArea(int[][] points) {
        double largestArea = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < length; j++) {
                int[] point2 = points[j];
                for (int k = j + 1; k < length; k++) {
                    int[] point3 = points[k];
                    if (sameLine(point1, point2, point3))
                        continue;
                    double area = getArea(point1, point2, point3);
                    largestArea = Math.max(largestArea, area);
                }
            }
        }
        return largestArea;
    }

    public boolean sameLine(int[] point1, int[] point2, int[] point3) {
        int delta1X = point2[0] - point1[0], delta1Y = point2[1] - point1[1];
        int delta2X = point3[0] - point2[0], delta2Y = point3[1] - point2[1];
        return delta1X * delta2Y == delta2X * delta1Y;
    }

    public double getArea(int[] point1, int[] point2, int[] point3) {
        double side1 = getDistance(point1, point2);
        double side2 = getDistance(point2, point3);
        double side3 = getDistance(point3, point1);
        double halfPerimeter = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
        return area;
    }

    public double getDistance(int[] point1, int[] point2) {
        return Math.sqrt(((double) point2[0] - (double) point1[0]) * ((double) point2[0] - (double) point1[0]) + ((double) point2[1] - (double) point1[1]) * ((double) point2[1] - (double) point1[1]));
    }
}