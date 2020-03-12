class Solution {
    public double minAreaFreeRect(int[][] points) {
        if (points == null || points.length < 4 || points[0].length != 2)
            return 0;
        int length = points.length;
        double minArea = Double.MAX_VALUE;
        int end1 = length - 3, end2 = length - 2, end3 = length - 1;
        for (int i = 0; i < end1; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < end2; j++) {
                int[] point2 = points[j];
                for (int k = j + 1; k < end3; k++) {
                    int[] point3 = points[k];
                    if (isRightAngle(point1, point2, point3)) {
                        for (int m = k + 1; m < length; m++) {
                            int[] point4 = points[m];
                            double area = rectangleArea(point1, point2, point3, point4);
                            if (area > 0)
                                minArea = Math.min(minArea, area);
                        }
                    } else if (isRightAngle(point2, point3, point1)) {
                        for (int m = k + 1; m < length; m++) {
                            int[] point4 = points[m];
                            double area = rectangleArea(point2, point3, point1, point4);
                            if (area > 0)
                                minArea = Math.min(minArea, area);
                        }
                    } else if (isRightAngle(point3, point1, point2)) {
                        for (int m = k + 1; m < length; m++) {
                            int[] point4 = points[m];
                            double area = rectangleArea(point3, point1, point2, point4);
                            if (area > 0)
                                minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    public double rectangleArea(int[] point1, int[] point2, int[] point3, int[] point4) {
        int x = point1[0] + point3[0] - point2[0], y = point1[1] + point3[1] - point2[1];
        if (point4[0] == x && point4[1] == y) {
            double side1 = Math.sqrt((point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]));
            double side2 = Math.sqrt((point2[0] - point3[0]) * (point2[0] - point3[0]) + (point2[1] - point3[1]) * (point2[1] - point3[1]));
            return side1 * side2;
        } else
            return 0;
    }

    public boolean isRightAngle(int[] point1, int[] point2, int[] point3) {
        return (point1[0] - point2[0]) * (point2[0] - point3[0]) + (point1[1] - point2[1]) * (point2[1] - point3[1]) == 0;
        
    }
}