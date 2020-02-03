class Solution {
    int rectsCount;
    int[][] rects;
    int[] accumulatedPoints;
    int pointsCount;

    public Solution(int[][] rects) {
        rectsCount = rects.length;
        this.rects = rects;
        accumulatedPoints = new int[rectsCount];
        for (int i = 0; i < rectsCount; i++) {
            int[] rect = rects[i];
            int points = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            accumulatedPoints[i] = points;
            pointsCount += points;
        }
        for (int i = 1; i < rectsCount; i++)
            accumulatedPoints[i] += accumulatedPoints[i - 1];
    }
    
    public int[] pick() {
        int pointsPosition = (int) (Math.random() * pointsCount);
        int index = 0;
        for (int i = 0; i < rectsCount; i++) {
            if (accumulatedPoints[i] > pointsPosition) {
                index = i;
                break;
            }
        }
        int[] rect = rects[index];
        int xMin = rect[0], xMax = rect[2];
        int yMin = rect[1], yMax = rect[3];
        int randomX = xMin + (int) (Math.random() * (xMax - xMin + 1));
        int randomY = yMin + (int) (Math.random() * (yMax - yMin + 1));
        int[] randomPoint = {randomX, randomY};
        return randomPoint;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */