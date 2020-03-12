class Solution {
    final int SIDE = 9;
    final int SUBSIDE = 3;
    boolean finish = false;

    public void solveSudoku(char[][] board) {
        fillFixedSudoku(board);
        List<int[]> emptyCellsList = new ArrayList<int[]>();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (board[i][j] == '.')
                    emptyCellsList.add(new int[]{i, j});
            }
        }
        solveSudoku(board, emptyCellsList);
    }

    public void fillFixedSudoku(char[][] board) {
        Map<Integer, List<Character>> possibleFills = new HashMap<Integer, List<Character>>();
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    if (board[i][j] == '.') {
                        List<Character> candidates = findCandidates(board, i, j);
                        if (candidates.size() == 1) {
                            flag = true;
                            char digit = candidates.get(0);
                            board[i][j] = digit;
                        } else
                            possibleFills.put(i * SIDE + j, candidates);
                    }
                }
            }
        }
    }

    public List<Character> findCandidates(char[][] board, int row, int column) {
        Set<Character> usedSet = new HashSet<Character>();
        for (int i = 0; i < SIDE; i++) {
            char digit = board[row][i];
            if (digit != '.')
                usedSet.add(digit);
        }
        for (int i = 0; i < SIDE; i++) {
            char digit = board[i][column];
            if (digit != '.')
                usedSet.add(digit);
        }
        int subboxStartRow = row / SUBSIDE * SUBSIDE, subboxStartColumn = column / SUBSIDE * SUBSIDE;
        for (int i = 0; i < SUBSIDE; i++) {
            int curRow = subboxStartRow + i;
            for (int j = 0; j < SUBSIDE; j++) {
                int curColumn = subboxStartColumn + j;
                char digit = board[curRow][curColumn];
                if (digit != '.')
                    usedSet.add(digit);
            }
        }
        List<Character> candidates = new ArrayList<Character>();
        for (char digit = '1'; digit <= '9'; digit++) {
            if (!usedSet.contains(digit))
                candidates.add(digit);
        }
        return candidates;
    }

    public void solveSudoku(char[][] board, List<int[]> emptyCellsList) {
        if (emptyCellsList.size() == 0) {
            finish = true;
            return;
        }
        int[] emptyCell = emptyCellsList.get(0);
        int row = emptyCell[0], column = emptyCell[1];
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isValidSudoku(board, row, column, digit)) {
                board[row][column] = digit;
                emptyCellsList.remove(0);
                solveSudoku(board, emptyCellsList);
                if (!finish) {
                    emptyCellsList.add(0, emptyCell);
                    board[row][column] = '.';
                }
            }
        }
    }

    public boolean isValidSudoku(char[][] board, int row, int column, char digit) {
        for (int i = 0; i < SIDE; i++) {
            if (i == column)
                continue;
            if (board[row][i] == digit)
                return false;
        }
        for (int i = 0; i < SIDE; i++) {
            if (i == row)
                continue;
            if (board[i][column] == digit)
                return false;
        }
        int subboxStartRow = row / SUBSIDE * SUBSIDE, subboxStartColumn = column / SUBSIDE * SUBSIDE;
        for (int i = 0; i < SUBSIDE; i++) {
            int curRow = subboxStartRow + i;
            for (int j = 0; j < SUBSIDE; j++) {
                int curColumn = subboxStartColumn + j;
                if (curRow == row && curColumn == column)
                    continue;
                if (board[curRow][curColumn] == digit)
                    return false;
            }
        }
        return true;
    }
}