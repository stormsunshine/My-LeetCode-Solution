class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        int maxPoints = 2;
        Set<String> visitedLines = new HashSet<String>();
        int pointsCount = points.length;
        for (int i = 0; i < pointsCount; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < pointsCount; j++) {
                int[] point2 = points[j];
                long[] coefficients = getCoefficients(points[i], points[j]);
                if (visitedLines.add(Arrays.toString(coefficients))) {
                    int curPoints = 0;
                    for (int[] point : points) {
                        if (coefficients[0] * (int) point[0] + coefficients[1] * (int) point[1] + coefficients[2] == 0)
                            curPoints++;
                    }
                    maxPoints = Math.max(maxPoints, curPoints);
                }
            }
        }
        return maxPoints;
    }

    public long[] getCoefficients(int[] point1, int[] point2) {
        if (point1[0] == point2[0])
            return new long[]{1, 0, -point1[0]};
        else if (point1[1] == point2[1])
            return new long[]{0, 1, -point1[1]};
        else {
            int coefficient1 = point2[1] - point1[1];
            int coefficient2 = point1[0] - point2[0];
            if (coefficient1 < 0) {
                coefficient1 *= -1;
                coefficient2 *= -1;
            }
            int coefficient3 = -coefficient1 * point1[0] - coefficient2 * point1[1];
            int gcd = gcd(coefficient1, coefficient2, coefficient3);
            coefficient1 /= gcd;
            coefficient2 /= gcd;
            coefficient3 /= gcd;
            return new long[]{coefficient1, coefficient2, coefficient3};
        }
    }

    public int gcd(int num1, int num2, int num3) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        num3 = Math.abs(num3);
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            num2 %= num1;
        }
        int num4 = num1 == 0 ? num2 : num1;
        while (num3 != 0 && num4 != 0) {
            if (num3 > num4) {
                int temp = num3;
                num3 = num4;
                num4 = temp;
            }
            num4 %= num3;
        }
        return num3 == 0 ? num4 : num3;
    }
}