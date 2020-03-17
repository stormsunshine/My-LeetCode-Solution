class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid) {
        int side = grid.length;
        int[][] islandNumbers = new int[side][side];
        int islandCount = 0;
        int maxSize = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<int[]> zeros = new ArrayList<int[]>();
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (grid[i][j] == 0)
                    zeros.add(new int[]{i, j});
                else if (islandNumbers[i][j] == 0) {
                    islandCount++;
                    int size = breadthFirstSearch(grid, islandNumbers, islandCount, i, j);
                    maxSize = Math.max(maxSize, size);
                    map.put(islandCount, size);
                }
            }
        }
        for (int[] zero : zeros) {
            int size = 1;
            Set<Integer> islandsSet = new HashSet<Integer>();
            int row = zero[0], column = zero[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < side && newColumn >= 0 && newColumn < side) {
                    int islandNumber = islandNumbers[newRow][newColumn];
                    if (islandNumber > 0)
                        islandsSet.add(islandNumber);
                }
            }
            for (int island : islandsSet)
                size += map.get(island);
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }

    public int breadthFirstSearch(int[][] grid, int[][] islandNumbers, int islandCount, int row, int column) {
        int size = 0;
        islandNumbers[row][column] = islandCount;
        int side = grid.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            size++;
            int curRow = cell[0], curColumn = cell[1];
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < side && newColumn >= 0 && newColumn < side && grid[newRow][newColumn] == 1 && islandNumbers[newRow][newColumn] == 0) {
                    islandNumbers[newRow][newColumn] = islandCount;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return size;
    }
}