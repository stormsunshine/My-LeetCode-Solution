/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     int move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    static final int MAX = 100;
    char[] directionsChar = {'U', 'L', 'D', 'R'};
    int[][] directionsArr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean flag = false;
    int endRow = 0, endColumn = 0;

    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[MAX * 2][MAX * 2];
        for (int i = 0; i < MAX * 2; i++)
            Arrays.fill(grid[i], -1);
        depthFirstSearch(MAX, MAX, grid, master);
        if (!flag)
            return -1;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] cell1, int[] cell2) {
                return cell1[2] - cell2[2];
            }
        });
        priorityQueue.offer(new int[]{100, 100, 0});
        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            int row = cell[0], column = cell[1], cost = cell[2];
            if (row == endRow && column == endColumn)
                return cost;
            for (int[] directionArr : directionsArr) {
                int newRow = row + directionArr[0], newColumn = column + directionArr[1];
                if (newRow >= 0 && newRow < MAX * 2 && newColumn >= 0 && newColumn < MAX * 2 && grid[newRow][newColumn] > 0) {
                    int newCost = cost + grid[newRow][newColumn];
                    grid[newRow][newColumn] = -1;
                    priorityQueue.offer(new int[]{newRow, newColumn, newCost});
                }
            }
        }
        return -1;
    }

    public void depthFirstSearch(int row, int column, int[][] grid, GridMaster master) {
        if (master.isTarget()) {
            endRow = row;
            endColumn = column;
            flag = true;
        }
        for (int i = 0; i < 4; i++) {
            char directionChar = directionsChar[i];
            char oppositeDirectionChar = directionsChar[(i + 2) % 4];
            int[] directionArr = directionsArr[i];
            int newRow = row + directionArr[0], newColumn = column + directionArr[1];
            if (master.canMove(directionChar) && grid[newRow][newColumn] < 0) {
                grid[newRow][newColumn] = master.move(directionChar);
                depthFirstSearch(newRow, newColumn, grid, master);
                master.move(oppositeDirectionChar);
            }
        }
    }
}