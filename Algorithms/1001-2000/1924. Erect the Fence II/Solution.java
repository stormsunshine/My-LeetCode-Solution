class Solution {
    public double[] outerTrees(int[][] trees) {
        double radius = 0.0;
        double x = trees[0][0], y = trees[0][1];
        int length = trees.length;
        for (int i = 1; i < length; i++) {
            if (getSquaredDistance(trees[i][0], x, trees[i][1], y) > radius * radius) {
                x = trees[i][0];
                y = trees[i][1];
                radius = 0.0;
                for (int j = 0; j < i; j++) {
                    if (getSquaredDistance(trees[j][0], x, trees[j][1], y) > radius * radius) {
                        x = (trees[i][0] + trees[j][0]) / 2.0;
                        y = (trees[i][1] + trees[j][1]) / 2.0;
                        radius = Math.sqrt(getSquaredDistance(x, trees[j][0], y, trees[j][1]));
                        for (int k = 0; k < j; k++) {
                            if (getSquaredDistance(trees[k][0], x, trees[k][1], y) > radius * radius) {
                                double[] circle = getCircle(trees, i, j, k);
                                x = circle[0];
                                y = circle[1];
                                radius = circle[2];
                            }
                        }
                    }
                }
            }
        }
        return new double[]{x, y, radius};
    }

    public double[] getCircle(int[][] trees, int i, int j, int k) {
        double p1 = trees[i][1] - trees[k][1], p2 = trees[i][1] - trees[j][1];
        double q1 = trees[i][0] - trees[k][0], q2 = trees[i][0] - trees[j][0];
        double a = (trees[i][0] * trees[i][0] - trees[j][0] * trees[j][0]) + (trees[i][1] * trees[i][1] - trees[j][1] * trees[j][1]);
        double b = (trees[i][0] * trees[i][0] - trees[k][0] * trees[k][0]) + (trees[i][1] * trees[i][1] - trees[k][1] * trees[k][1]);
        double c = 2 * (trees[i][0] - trees[j][0]) * (trees[i][1] - trees[k][1]) - 2 * (trees[i][0] - trees[k][0]) * (trees[i][1] - trees[j][1]);
        double x = (p1 * a - p2 * b) / c;
        double y = (q2 * b - q1 * a) / c;
        double radius = Math.sqrt(getSquaredDistance(trees[k][0], x, trees[k][1], y));
        return new double[]{x, y, radius};
    }

    public double getSquaredDistance(double x1, double x2, double y1, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}