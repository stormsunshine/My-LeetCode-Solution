class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0;
        int maxDistance = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int curSquirrelDistance = manhattanDistance(squirrel, nut);
            int curNutDistance = manhattanDistance(tree, nut);
            totalDistance += curNutDistance * 2;
            maxDistance = Math.max(maxDistance, curNutDistance - curSquirrelDistance);
        }
        return totalDistance - maxDistance;
    }

    public int manhattanDistance(int[] position1, int[] position2) {
        return Math.abs(position1[0] - position2[0]) + Math.abs(position1[1] - position2[1]);
    }
}