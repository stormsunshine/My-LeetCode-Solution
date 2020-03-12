class Solution {
    public int slidingPuzzle(int[][] board) {
        if (isSolved(board))
            return 0;
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(arrayToString(board));
        int zeroRow = -1, zeroColumn = -1;
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zeroRow = i;
                    zeroColumn = j;
                    break outer;
                }
            }
        }
        int moves = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[][]> stateQueue = new LinkedList<int[][]>();
        Queue<int[]> zeroQueue = new LinkedList<int[]>();
        stateQueue.offer(board);
        zeroQueue.offer(new int[]{zeroRow, zeroColumn});
        while (!stateQueue.isEmpty()) {
            moves++;
            int size = stateQueue.size();
            for (int i = 0; i < size; i++) {
                int[][] prevState = stateQueue.poll();
                int[] zero = zeroQueue.poll();
                int curRow = zero[0], curColumn = zero[1];
                for (int[] direction : directions) {
                    int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
                    if (newRow >= 0 && newRow < 2 && newColumn >= 0 && newColumn < 3) {
                        int[][] newState = new int[2][3];
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 3; k++)
                                newState[j][k] = prevState[j][k];
                        }
                        newState[curRow][curColumn] = prevState[newRow][newColumn];
                        newState[newRow][newColumn] = prevState[curRow][curColumn];
                        if (isSolved(newState))
                            return moves;
                        else {
                            String boardStr = arrayToString(newState);
                            if (visitedSet.add(boardStr)) {
                                stateQueue.offer(newState);
                                zeroQueue.offer(new int[]{newRow, newColumn});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public String arrayToString(int[][] board) {
        return "[" + Arrays.toString(board[0]) + ", " + Arrays.toString(board[1]) + "]";
    }

    public boolean isSolved(int[][] board) {
        for (int i = 0; i < 2; i++) {
            if (board[0][i] != i + 1 || board[1][i] != i + 4)
                return false;
        }
        if (board[0][2] != 3 || board[1][2] != 0)
            return false;
        return true;
    }
}