/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        Map<String, Integer> visitedMap = new HashMap<String, Integer>();
        visitedMap.put(Arrays.toString(new int[]{0, 0}), GRAY);
        int directionIndex = 0;
        depthFirstSearch(robot, directionIndex, visitedMap, 0, 0);
    }

    public void depthFirstSearch(Robot robot, int directionIndex, Map<String, Integer> visitedMap, int row, int column) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int[] direction = directions[directionIndex];
            int newRow = row + direction[0], newColumn = column + direction[1];
            int[] newCell = {newRow, newColumn};
            int color = visitedMap.getOrDefault(Arrays.toString(newCell), WHITE);
            if (color == WHITE && robot.move()) {
                visitedMap.put(Arrays.toString(newCell), GRAY);
                depthFirstSearch(robot, directionIndex, visitedMap, newRow, newColumn);
                for (int j = 0; j < 2; j++)
                    robot.turnRight();
                robot.move();
                for (int j = 0; j < 2; j++)
                    robot.turnRight();
            }
            robot.turnRight();
            directionIndex = (directionIndex + 1) % 4;
        }
        visitedMap.put(Arrays.toString(new int[]{row, column}), BLACK);
    }
}