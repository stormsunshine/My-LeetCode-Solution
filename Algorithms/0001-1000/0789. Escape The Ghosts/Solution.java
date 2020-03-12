class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        int distance = manhattanDistance(source, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost, target);
            if (ghostDistance <= distance)
                return false;
        }
        return true;
    }

    public int manhattanDistance(int[] source, int[] target) {
        return Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
    }
}