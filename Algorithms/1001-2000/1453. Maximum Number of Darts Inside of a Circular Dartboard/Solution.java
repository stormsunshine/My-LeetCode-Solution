class Solution {
    public int numPoints(int[][] points, int r) {
        int maxPoints = 1;
        int pointsCount = points.length;
        for (int i = 0; i < pointsCount; i++) {
            for (int j = i + 1; j < pointsCount; j++) {
                double[][] intersections = getIntersections(points[i], points[j], r);
                for (double[] intersection : intersections) {
                    int pointsInCircle = 0;
                    for (int[] point : points) {
                        double distance = distance(intersection, point);
                        if (distance <= r + 1e-5)
                            pointsInCircle++;
                    }
                    maxPoints = Math.max(maxPoints, pointsInCircle);
                }
            }
        }
        return maxPoints;
    }

    public double[][] getIntersections(int[] point1, int[] point2, int radius) {
        int squaredDistance = squaredDistance(point1, point2);
        if (squaredDistance > radius * radius * 4)
            return new double[0][2];
        else if (squaredDistance == radius * radius * 4) {
            double[] intersection = new double[2];
            for (int i = 0; i < 2; i++)
                intersection[i] = (point1[i] + point2[i]) / 2.0;
            double[][] intersections = new double[1][2];
            intersections[0] = intersection;
            return intersections;
        } else {
            double[] midPoint = new double[2];
            for (int i = 0; i < 2; i++)
                midPoint[i] = (point1[i] + point2[i]) / 2.0;
            double remaining = Math.sqrt(radius * radius - squaredDistance / 4.0);
            int difference1 = point1[1] - point2[1];
            int difference2 = point2[0] - point1[0];
            double radian = Math.atan(1.0 * difference2 / difference1);
            double[] intersection0 = {midPoint[0] + remaining * Math.cos(radian), midPoint[1] + remaining * Math.sin(radian)};
            double[] intersection1 = {midPoint[0] - remaining * Math.cos(radian), midPoint[1] - remaining * Math.sin(radian)};
            double[][] intersections = new double[2][2];
            intersections[0] = intersection0;
            intersections[1] = intersection1;
            return intersections;
        }
    }

    public int squaredDistance(int[] point1, int[] point2) {
        return (point2[0] - point1[0]) * (point2[0] - point1[0]) + (point2[1] - point1[1]) * (point2[1] - point1[1]);
    }

    public double distance(double[] point1, int[] point2) {
        return Math.sqrt((point2[0] - point1[0]) * (point2[0] - point1[0]) + (point2[1] - point1[1]) * (point2[1] - point1[1]));
    }
}