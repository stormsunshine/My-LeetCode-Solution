class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> allCellsList = new ArrayList<int[]>();
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int[][] colors = new int[R][C];
        colors[r0][c0] = GRAY;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r0, c0});
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            allCellsList.add(cell);
            int row = cell[0], column = cell[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < R && newColumn >= 0 && newColumn < C && colors[newRow][newColumn] == WHITE) {
                    colors[newRow][newColumn] = GRAY;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            colors[row][column] = BLACK;
        }
        int length = allCellsList.size();
        int[][] allCellsArray = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] cell = allCellsList.get(i);
            allCellsArray[i][0] = cell[0];
            allCellsArray[i][1] = cell[1];
        }
        return allCellsArray;
    }
}