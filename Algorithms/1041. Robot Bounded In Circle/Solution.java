class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0)
            return true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int xPosition = 0, yPosition = 0;
        int length = instructions.length();
        for (int i = 0; i < length; i++) {
            char instruction = instructions.charAt(i);
            if (instruction == 'G') {
                int[] direction = directions[directionIndex];
                xPosition += direction[0];
                yPosition += direction[1];
            } else if (instruction == 'L')
                directionIndex = (directionIndex + 3) % 4;
            else if (instruction == 'R')
                directionIndex = (directionIndex + 1) % 4;
        }
        return xPosition == 0 && yPosition == 0 || directionIndex != 0;
    }
}