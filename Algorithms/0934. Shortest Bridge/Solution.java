class Solution {
    public int shortestBridge(int[][] A) {
        if (A == null || A.length <= 1)
            return 0;
        int sideLength = A.length;
        int islandRow = -1, islandColumn = -1;
        outer:
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (A[i][j] == 1) {
                    islandRow = i;
                    islandColumn = j;
                    break outer;
                }
            }
        }
        List<int[]> cells = breadthFirstSearch(A, islandRow, islandColumn);
        int minDistance = breadthFirstSearch(A, cells);
        return minDistance - 1;
    }

    public List<int[]> breadthFirstSearch(int[][] array, int row, int column) {
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        List<int[]> cells = new ArrayList<int[]>();
        int sideLength = array.length;
        int[][] colors = new int[sideLength][sideLength];
        colors[row][column] = GRAY;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            cells.add(cell);
            int curRow = cell[0], curColumn = cell[1];
            array[curRow][curColumn] = 2;
            for (int[] direction : directions) {
                int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                if (newRow >= 0 && newRow < sideLength && newColumn >= 0 && newColumn < sideLength) {
                    if (array[newRow][newColumn] == 1 && colors[newRow][newColumn] == WHITE) {
                        colors[newRow][newColumn] = GRAY;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            colors[curRow][curColumn] = BLACK;
        }
        return cells;
    }

    public int breadthFirstSearch(int[][] array, List<int[]> cells) {
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int sideLength = array.length;
        int[][] colors = new int[sideLength][sideLength];
        int distance = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int[] cell : cells) {
            colors[cell[0]][cell[1]] = GRAY;
            queue.offer(cell);
        }
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newColumn = column + direction[1];
                    if (newRow >= 0 && newRow < sideLength && newColumn >= 0 && newColumn < sideLength) {
                        if (array[newRow][newColumn] == 1)
                            return distance;
                        else if (array[newRow][newColumn] != 2 && colors[newRow][newColumn] == WHITE) {
                            colors[newRow][newColumn] = GRAY;
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return distance;
    }
}