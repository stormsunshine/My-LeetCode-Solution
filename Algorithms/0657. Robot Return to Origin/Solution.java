class Solution {
    public boolean judgeCircle(String moves) {
        String directionsStr = "RLUD";
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] position = {0, 0};
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char directionChar = moves.charAt(i);
            int index = directionsStr.indexOf(directionChar);
            int[] direction = directions[index];
            for (int j = 0; j < 2; j++)
                position[j] += direction[j];
        }
        return position[0] == 0 && position[1] == 0;
    }
}