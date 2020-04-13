class Solution {
    public int containVirus(int[][] grid) {
        int walls = 0;
        int rows = grid.length, columns = grid[0].length;
        boolean flag = true;
        while (flag) {
            flag = false;
            int maxArea = 0;
            int maxIndex = -1;
            int index = 0;
            List<int[]> startCells = new ArrayList<int[]>();
            List<Integer> perimeters = new ArrayList<Integer>();
            boolean[][] visited = new boolean[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        flag = true;
                        int[] perimeterArea = breadthFirstSearch(grid, i, j, visited);
                        int perimeter = perimeterArea[0], area = perimeterArea[1];
                        if (area > maxArea) {
                            maxArea = area;
                            maxIndex = index;
                        }
                        startCells.add(new int[]{i, j});
                        perimeters.add(perimeter);
                        index++;
                    }
                }
            }
            if (maxIndex < 0)
                break;
            walls += perimeters.get(maxIndex);
            updateCellValues(grid, startCells.get(maxIndex));
            List<int[]> affectedCells = new ArrayList<int[]>();
            int size = perimeters.size();
            for (int i = 0; i < size; i++) {
                if (i != maxIndex)
                    spread(grid, startCells.get(i), affectedCells);
            }
            for (int[] cell : affectedCells)
                grid[cell[0]][cell[1]] = 1;
        }
        return walls;
    }

    public int[] breadthFirstSearch(int[][] grid, int startRow, int startColumn, boolean[][] visited) {
        int perimeter = 0;
        Set<String> set = new HashSet<String>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, columns = grid[0].length;
        visited[startRow][startColumn] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{startRow, startColumn});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (grid[newRow][newColumn] == 0) {
                        perimeter++;
                        set.add(Arrays.toString(new int[]{newRow, newColumn}));
                    } else if (grid[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        return new int[]{perimeter, set.size()};
    }

    public void updateCellValues(int[][] grid, int[] startCell) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(startCell);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            grid[row][column] = -1;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1) {
                    grid[newRow][newColumn] = 2;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
    }

    public void spread(int[][] grid, int[] startCell, List<int[]> affectedCells) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[startCell[0]][startCell[1]] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(startCell);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (grid[newRow][newColumn] == 0)
                        affectedCells.add(new int[]{newRow, newColumn});
                    else if (grid[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
    }
}