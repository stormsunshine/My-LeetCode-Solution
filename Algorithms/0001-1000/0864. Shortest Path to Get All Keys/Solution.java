class Solution {
    public int shortestPathAllKeys(String[] grid) {
        final int STATES = 1 << 6;
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = grid.length, columns = grid[0].length();
        int startRow = -1, startColumn = -1;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            String curRow = grid[i];
            for (int j = 0; j < columns; j++) {
                if (curRow.charAt(j) == '@') {
                    startRow = i;
                    startColumn = j;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        int targetKeys = 0;
        for (int i = 0; i < rows; i++) {
            String curRow = grid[i];
            for (int j = 0; j < columns; j++) {
                char c = curRow.charAt(j);
                if (Character.isLetter(c) && c < 'a') {
                    int index = c - 'A';
                    targetKeys |= 1 << index;
                }
            }
        }
        int[][][] colors = new int[rows][columns][STATES];
        int[][][] distances = new int[rows][columns][STATES];
        for (int i = 0; i < rows; i++) {
            String curRow = grid[i];
            for (int j = 0; j < columns; j++) {
                char c = curRow.charAt(j);
                if (c == '#') {
                    for (int k = 0; k < STATES; k++)
                        colors[i][j][k] = BLOCK;
                }
                for (int k = 0; k < STATES; k++)
                    distances[i][j][k] = Integer.MAX_VALUE;
            }
        }
        colors[startRow][startColumn][0] = GRAY;
        distances[startRow][startColumn][0] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{startRow, startColumn, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1], keys = cell[2];
            int distance = distances[row][column][keys];
            if (keys == targetKeys)
                return distance;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    char c = grid[newRow].charAt(newColumn);
                    if (c == '#')
                        continue;
                    else if (c == '.' || c == '@') {
                        if (colors[newRow][newColumn][keys] == WHITE) {
                            colors[newRow][newColumn][keys] = GRAY;
                            distances[newRow][newColumn][keys] = distance + 1;
                            queue.offer(new int[]{newRow, newColumn, keys});
                        }
                    } else if (Character.isLetter(c)) {
                        if (c >= 'a') {
                            int index = c - 'a';
                            int newKeys = keys | 1 << index;
                            if (colors[newRow][newColumn][newKeys] == WHITE) {
                                colors[newRow][newColumn][newKeys] = GRAY;
                                distances[newRow][newColumn][newKeys] = distance + 1;
                                queue.offer(new int[]{newRow, newColumn, newKeys});
                            }
                        } else {
                            int index = c - 'A';
                            int curKey = keys >> index & 1;
                            if (curKey == 1) {
                                if (colors[newRow][newColumn][keys] == WHITE) {
                                    colors[newRow][newColumn][keys] = GRAY;
                                    distances[newRow][newColumn][keys] = distance + 1;
                                    queue.offer(new int[]{newRow, newColumn, keys});
                                }
                            }
                        }
                    }
                }
            }
            colors[row][column][keys] = BLACK;
        }
        return -1;
    }
}