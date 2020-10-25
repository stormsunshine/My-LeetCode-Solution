class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, columns = heights[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[][] values = new int[rows][columns];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[3] != array2[3])
                    return array1[3] - array2[3];
                else if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        priorityQueue.offer(new int[]{0, 0, heights[0][0], values[0][0]});
        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            int row = cell[0], column = cell[1], height = cell[2], value = cell[3];
            for (int i = 0; i < 4; i++) {
                int[] direction = directions[i];
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (!visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        values[newRow][newColumn] = Math.max(value, Math.abs(heights[newRow][newColumn] - height));
                        priorityQueue.offer(new int[]{newRow, newColumn, heights[newRow][newColumn], values[newRow][newColumn]});
                    } else {
                        int newValue = Math.max(value, Math.abs(heights[newRow][newColumn] - height));
                        if (newValue < values[newRow][newColumn]) {
                            values[newRow][newColumn] = Math.max(value, Math.abs(heights[newRow][newColumn] - height));
                            priorityQueue.offer(new int[]{newRow, newColumn, heights[newRow][newColumn], values[newRow][newColumn]});
                        }
                    }
                }
            }
        }
        return values[rows - 1][columns - 1];
    }
}