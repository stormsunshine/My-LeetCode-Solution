class Solution {
    Set<Integer> set = new HashSet<Integer>();

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int length = positions.length;
        List<Integer> islands = new ArrayList<Integer>();
        int islandsCount = 0;
        for (int i = 0; i < length; i++) {
            int[] position = positions[i];
            int row = position[0], column = position[1];
            if (grid[row][column] != 0) {
                islands.add(set.size());
                continue;
            }
            int minAdjacent = Integer.MAX_VALUE;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && grid[newRow][newColumn] != 0)
                    minAdjacent = Math.min(minAdjacent, grid[newRow][newColumn]);
            }
            if (minAdjacent == Integer.MAX_VALUE) {
                set.add(islandsCount + 1);
                islandsCount++;
                grid[row][column] = islandsCount;
            } else {
                grid[row][column] = minAdjacent;
                breadthFirstSearch(grid, row, column);
            }
            islands.add(set.size());
        }
        return islands;
    }

    public void breadthFirstSearch(int[][] grid, int row, int column) {
        int m = grid.length, n = grid[0].length;
        int curNumber = grid[row][column];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] square = queue.poll();
            int curRow = square[0], curColumn = square[1];
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                    int prevNumber = grid[newRow][newColumn];
                    if (prevNumber > curNumber) {
                        grid[newRow][newColumn] = curNumber;
                        set.remove(prevNumber);
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
    }
}