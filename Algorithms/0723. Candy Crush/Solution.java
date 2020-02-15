class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length, columns = board[0].length;
        boolean stable = false;
        while (!stable) {
            stable = true;
            List<int[]> removeList = new ArrayList<int[]>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (board[i][j] != 0) {
                        List<int[]> curRemoveList = search(board, i, j);
                        if (curRemoveList.size() > 0) {
                            removeList.addAll(curRemoveList);
                            stable = false;
                        }
                    }
                }
            }
            for (int[] cell : removeList)
                board[cell[0]][cell[1]] = 0;
            if (!stable)
                updateBoard(board);
        }
        return board;
    }

    public List<int[]> search(int[][] board, int row, int column) {
        List<int[]> curRemoveList = new ArrayList<int[]>();
        int value = board[row][column];
        if (value == 0)
            return curRemoveList;
        int rows = board.length, columns = board[0].length;
        int[][] directions = {{1, 0}, {0, 1}};
        for (int[] direction : directions) {
            List<int[]> directionRemoveList = new ArrayList<int[]>();
            int newRow = row + direction[0], newColumn = column + direction[1];
            while (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && board[newRow][newColumn] == value) {
                directionRemoveList.add(new int[]{newRow, newColumn});
                newRow += direction[0];
                newColumn += direction[1];
            }
            if (directionRemoveList.size() >= 2)
                curRemoveList.addAll(directionRemoveList);
        }
        if (curRemoveList.size() > 0)
            curRemoveList.add(new int[]{row, column});
        return curRemoveList;
    }

    public void updateBoard(int[][] board) {
        int rows = board.length, columns = board[0].length;
        for (int i = 0; i < columns; i++) {
            int index1 = rows - 1, index2 = rows - 1;
            while (index1 >= 0) {
                if (board[index1][i] == 0)
                    index1--;
                else
                    board[index2--][i] = board[index1--][i];
            }
            while (index2 >= 0)
                board[index2--][i] = 0;
        }
    }
}