class Solution {
    public double getMinDistSum(int[][] positions) {
        int length = positions.length;
        if (length == 1)
            return 0;
        double xCentre = -1, yCentre = -1;
        final double EPSILON = 1e-6;
        double difference = 1;
        while (difference > EPSILON) {
            double xNumerator = 0, yNumerator = 0, denominator = 0;
            for (int[] position : positions) {
                double distance = euclideanDistance(xCentre, yCentre, position[0], position[1]);
                if (distance != 0) {
                    xNumerator += position[0] / distance;
                    yNumerator += position[1] / distance;
                    denominator += 1 / distance;
                }
            }
            if (denominator == 0)
                break;
            double xCentreNew = xNumerator / denominator, yCentreNew = yNumerator / denominator;
            difference = euclideanDistance(xCentre, yCentre, xCentreNew, yCentreNew);
            xCentre = xCentreNew;
            yCentre = yCentreNew;
        }
        double distanceSum = 0;
        for (int[] position : positions)
            distanceSum += euclideanDistance(xCentre, yCentre, position[0], position[1]);
        return distanceSum;
    }

    public double euclideanDistance(double x0, double y0, double x1, double y1) {
        return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
    }
}