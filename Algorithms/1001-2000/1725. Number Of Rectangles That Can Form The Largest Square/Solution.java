class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int width = 0;
        for (int[] rectangle : rectangles) {
            int shorter = Math.min(rectangle[0], rectangle[1]);
            width = Math.max(width, shorter);
        }
        int count = 0;
        for (int[] rectangle : rectangles) {
            int shorter = Math.min(rectangle[0], rectangle[1]);
            count += shorter == width ? 1 : 0;
        }
        return count;
    }
}