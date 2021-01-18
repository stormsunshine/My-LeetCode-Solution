class Solution {
    int rows, columns;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        rows = grid.length;
        columns = grid[0].length();
        int[][][][][] degrees = new int[rows][columns][rows][columns][2];
        int startCatRow = -1, startCatColumn = -1, startMouseRow = -1, startMouseColumn = -1, foodRow = -1, foodColumn = -1;
        for (int i = 0; i < rows; i++) {
            String row = grid[i];
            for (int j = 0; j < columns; j++) {
                if (row.charAt(j) == 'C') {
                    startCatRow = i;
                    startCatColumn = j;
                } else if (row.charAt(j) == 'M') {
                    startMouseRow = i;
                    startMouseColumn = j;
                } else if (row.charAt(j) == 'F') {
                    foodRow = i;
                    foodColumn = j;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            String row = grid[i];
            for (int j = 0; j < columns; j++) {
                if (row.charAt(j) != '#') {
                    for (int k = 0; k < rows; k++) {
                        String row2 = grid[k];
                        for (int m = 0; m < columns; m++) {
                            if (row2.charAt(m) != '#') {
                                degrees[i][j][k][m][0] = getNeighbors(grid, k, m, mouseJump).size();
                                degrees[i][j][k][m][1] = getNeighbors(grid, i, j, catJump).size();
                            }
                        }
                    }
                }
            }
        }
        int[][][][][] game = new int[rows][columns][rows][columns][2];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; i++) {
            String row = grid[i];
            for (int j = 0; j < columns; j++) {
                if (row.charAt(j) != '#' && row.charAt(j) != 'F') {
                    game[i][j][i][j][0] = -1;
                    game[i][j][i][j][1] = 1;
                    queue.offer(new int[]{i, j, i, j, 0});
                    queue.offer(new int[]{i, j, i, j, 1});
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            String row = grid[i];
            for (int j = 0; j < columns; j++) {
                if (row.charAt(j) != '#' && row.charAt(j) != 'F') {
                    game[foodRow][foodColumn][i][j][0] = -1;
                    game[i][j][foodRow][foodColumn][1] = -1;
                    queue.offer(new int[]{foodRow, foodColumn, i, j, 0});
                    queue.offer(new int[]{i, j, foodRow, foodColumn, 1});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int catRow = state[0], catColumn = state[1], mouseRow = state[2], mouseColumn = state[3], turn = state[4];
            if (turn == 0) {
                List<int[]> neighbors = getNeighbors(grid, catRow, catColumn, catJump);
                for (int[] neighbor : neighbors) {
                    int row = neighbor[0], column = neighbor[1];
                    degrees[row][column][mouseRow][mouseColumn][turn ^ 1]--;
                    if (game[row][column][mouseRow][mouseColumn][turn ^ 1] == 0) {
                        if (game[catRow][catColumn][mouseRow][mouseColumn][turn] == -1) {
                            game[row][column][mouseRow][mouseColumn][turn ^ 1] = 1;
                            queue.offer(new int[]{row, column, mouseRow, mouseColumn, turn ^ 1});
                        } else if (degrees[row][column][mouseRow][mouseColumn][turn ^ 1] == 0) {
                            game[row][column][mouseRow][mouseColumn][turn ^ 1] = -1;
                            queue.offer(new int[]{row, column, mouseRow, mouseColumn, turn ^ 1});
                        }
                    }
                }
            } else {
                List<int[]> neighbors = getNeighbors(grid, mouseRow, mouseColumn, mouseJump);
                for (int[] neighbor : neighbors) {
                    int row = neighbor[0], column = neighbor[1];
                    degrees[catRow][catColumn][row][column][turn ^ 1]--;
                    if (game[catRow][catColumn][row][column][turn ^ 1] == 0) {
                        if (game[catRow][catColumn][mouseRow][mouseColumn][turn] == -1) {
                            game[catRow][catColumn][row][column][turn ^ 1] = 1;
                            queue.offer(new int[]{catRow, catColumn, row, column, turn ^ 1});
                        } else if (degrees[catRow][catColumn][row][column][turn ^ 1] == 0) {
                            game[catRow][catColumn][row][column][turn ^ 1] = -1;
                            queue.offer(new int[]{catRow, catColumn, row, column, turn ^ 1});
                        }
                    }
                }
            }
        }
        return game[startCatRow][startCatColumn][startMouseRow][startMouseColumn][0] == 1;
    }

    public List<int[]> getNeighbors(String[] grid, int row, int column, int maxJump) {
        List<int[]> neighbors = new ArrayList<int[]>();
        neighbors.add(new int[]{row, column});
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int curRow = row, curColumn = column;
            for (int i = 1; i <= maxJump; i++) {
                curRow += direction[0];
                curColumn += direction[1];
                if (curRow < 0 || curRow >= rows || curColumn < 0 || curColumn >= columns || grid[curRow].charAt(curColumn) == '#')
                    break;
                neighbors.add(new int[]{curRow, curColumn});
            }
        }
        return neighbors;
    }
}