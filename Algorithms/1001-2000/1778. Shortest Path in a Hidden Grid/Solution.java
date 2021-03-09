/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    static final int MAX = 500;
    char[] directionsChar = {'U', 'L', 'D', 'R'};
    int[][] directionsArr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean flag = false;

    public int findShortestPath(GridMaster master) {
        Set<String> visited1 = new HashSet<String>();
        int[][] grid = new int[MAX * 2][MAX * 2];
        grid[MAX][MAX] = -1;
        depthFirstSearch(MAX, MAX, visited1, grid, master);
        if (!flag)
            return -1;
        int distance = 0;
        boolean[][] visited2 = new boolean[MAX * 2][MAX * 2];
        visited2[MAX][MAX] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{MAX, MAX});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                if (grid[row][column] == 2)
                    return distance;
                for (int[] directionArr : directionsArr) {
                    int newRow = row + directionArr[0], newColumn = column + directionArr[1];
                    if (!visited2[newRow][newColumn] && grid[newRow][newColumn] != 0) {
                        visited2[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public void depthFirstSearch(int row, int column, Set<String> visited, int[][] grid, GridMaster master) {
        grid[row][column] = 1;
        if (master.isTarget()) {
            grid[row][column] = 2;
            flag = true;
        }
        for (int i = 0; i < 4; i++) {
            char directionChar = directionsChar[i];
            char oppositeDirectionChar = directionsChar[(i + 2) % 4];
            int[] directionArr = directionsArr[i];
            int newRow = row + directionArr[0], newColumn = column + directionArr[1];
            String newStr = Arrays.toString(new int[]{newRow, newColumn});
            if (!visited.contains(newStr) && master.canMove(directionChar)) {
                visited.add(newStr);
                master.move(directionChar);
                depthFirstSearch(newRow, newColumn, visited, grid, master);
                master.move(oppositeDirectionChar);
            }
        }
    }
}