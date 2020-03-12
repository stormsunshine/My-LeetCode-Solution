class Solution {
    public boolean isBoomerang(int[][] points) {
        int difX1 = points[1][0] - points[0][0], difY1 = points[1][1] - points[0][1];
        int difX2 = points[2][0] - points[1][0], difY2 = points[2][1] - points[1][1];
        return difX1 * difY2 != difX2 * difY1;
    }
}