class Solution {
    int rows;
    int columns;

    public int numDistinctIslands2(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Integer> shapeList = breadthFirstSearch(grid, visited, i, j);
                    if (!shapeList.isEmpty()) {
                        String shapeStr = getShape(shapeList);
                        set.add(shapeStr);
                    }
                }
            }
        }
        return set.size();
    }

    public List<Integer> breadthFirstSearch(int[][] grid, boolean[][] visited, int row, int column) {
        List<Integer> shapeList = new ArrayList<Integer>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[row][column] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curRow = cell[0], curColumn = cell[1];
            shapeList.add(curRow * columns + curColumn);
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return shapeList;
    }

    public String getShape(List<Integer> shapeList) {
        String shapeStr = "";
        int multiple = rows + columns;
        int[][] signs = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        int size = shapeList.size();
        for (int i = 0; i < 4; i++) {
            int[] rowArray = new int[size];
            int[] columnArray = new int[size];
            for (int j = 0; j < size; j++) {
                int position = shapeList.get(j);
                rowArray[j] = position / columns * signs[i][0];
                columnArray[j] = position % columns * signs[i][1];
            }
            int rowMin = rowArray[0], columnMin = columnArray[0];
            for (int row : rowArray)
                rowMin = Math.min(rowMin, row);
            for (int column : columnArray)
                columnMin = Math.min(columnMin, column);
            int[] shapeArray1 = new int[size];
            int[] shapeArray2 = new int[size];
            for (int j = 0; j < size; j++) {
                shapeArray1[j] = (rowArray[j] - rowMin) * multiple + (columnArray[j] - columnMin);
                shapeArray2[j] = (columnArray[j] - columnMin) * multiple + (rowArray[j] - rowMin);
            }
            Arrays.sort(shapeArray1);
            Arrays.sort(shapeArray2);
            String shapeStr1 = Arrays.toString(shapeArray1);
            String shapeStr2 = Arrays.toString(shapeArray2);
            if (shapeStr.compareTo(shapeStr1) < 0)
                shapeStr = shapeStr1;
            if (shapeStr.compareTo(shapeStr2) < 0)
                shapeStr = shapeStr2;
        }
        return shapeStr;
    }
}