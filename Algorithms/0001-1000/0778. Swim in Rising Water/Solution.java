class Solution {
    public int swimInWater(int[][] grid) {
        int sideLength = grid.length;
        int totalCells = sideLength * sideLength;
        int minTime = Math.max(grid[0][0], grid[sideLength - 1][sideLength - 1]);
        boolean[][] visited = new boolean[sideLength][sideLength];
        visited[0][0] = true;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] cell1, int[] cell2) {
                return grid[cell1[0]][cell1[1]] - grid[cell2[0]][cell2[1]];
            }
        });
        priorityQueue.offer(new int[]{0, 0});
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            minTime = Math.max(minTime, grid[cell[0]][cell[1]]);
            if (cell[0] == sideLength - 1 && cell[1] == sideLength - 1)
                break;
            for (int[] direction : directions) {
                int newRow = cell[0] + direction[0], newColumn = cell[1] + direction[1];
                if (newRow >= 0 && newRow < sideLength && newColumn >= 0 && newColumn < sideLength && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    priorityQueue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return minTime;
    }
}