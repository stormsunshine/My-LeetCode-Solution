class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        Queue<int[]> pacificQueue = new LinkedList<int[]>();
        Queue<int[]> atlanticQueue = new LinkedList<int[]>();
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] pacificFlows = new boolean[rows][columns];
        boolean[][] atlanticFlows = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            pacificFlows[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});
        }
        for (int i = 1; i < columns; i++) {
            pacificFlows[0][i] = true;
            pacificQueue.offer(new int[]{0, i});
        }
        for (int i = 0; i < rows; i++) {
            atlanticFlows[i][columns - 1] = true;
            atlanticQueue.offer(new int[]{i, columns - 1});
        }
        for (int i = 0; i < columns - 1; i++) {
            atlanticFlows[rows - 1][i] = true;
            atlanticQueue.offer(new int[]{rows - 1, i});
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pacificQueue.isEmpty()) {
            int[] cell = pacificQueue.poll();
            int row = cell[0], column = cell[1];
            int height = matrix[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (matrix[newRow][newColumn] >= height && !pacificFlows[newRow][newColumn]) {
                        pacificFlows[newRow][newColumn] = true;
                        pacificQueue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        while (!atlanticQueue.isEmpty()) {
            int[] cell = atlanticQueue.poll();
            int row = cell[0], column = cell[1];
            int height = matrix[row][column];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (matrix[newRow][newColumn] >= height && !atlanticFlows[newRow][newColumn]) {
                        atlanticFlows[newRow][newColumn] = true;
                        atlanticQueue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pacificFlows[i][j] && atlanticFlows[i][j]) {
                    List<Integer> coordinate = new ArrayList<Integer>();
                    coordinate.add(i);
                    coordinate.add(j);
                    list.add(coordinate);
                }
            }
        }
        return list;
    }
}