class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 2)
            return true;
        int deltaX = coordinates[1][0] - coordinates[0][0], deltaY = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < length; i++) {
            int curDeltaX = coordinates[i][0] - coordinates[i - 1][0], curDeltaY = coordinates[i][1] - coordinates[i - 1][1];
            if (deltaX * curDeltaY != deltaY * curDeltaX)
                return false;
        }
        return true;
    }
}