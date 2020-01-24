class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsInBoard = new ArrayList<String>();
        for (String word : words) {
            if (exist(board, word))
                wordsInBoard.add(word);
        }
        return wordsInBoard;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        char startLetter = word.charAt(0);
        List<int[]> startPositions = new ArrayList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == startLetter)
                    startPositions.add(new int[]{i, j});
            }
        }
        for (int[] startPosition : startPositions) {
            boolean exist = depthFirstSearch(board, word, startPosition, visited);
            if (exist)
                return true;
        }
        return false;
    }

    public boolean depthFirstSearch(char[][] board, String word, int[] startPosition, boolean[][] visited) {
        return depthFirstSearch(board, word, startPosition, visited, 0);
    }

    public boolean depthFirstSearch(char[][] board, String word, int[] startPosition, boolean[][] visited, int startIndex) {
        int rows = board.length, columns = board[0].length;
        int length = word.length();
        int startRow = startPosition[0], startColumn = startPosition[1];
        if (startIndex == length - 1)
            return board[startRow][startColumn] == word.charAt(startIndex);
        if (board[startRow][startColumn] != word.charAt(startIndex))
            return false;
        visited[startRow][startColumn] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newRow = startRow + direction[0], newColumn = startColumn + direction[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn]) {
                int[] newPosition = {newRow, newColumn};
                int newIndex = startIndex + 1;
                if (depthFirstSearch(board, word, newPosition, visited, newIndex))
                    return true;
            }
        }
        visited[startRow][startColumn] = false;
        return false;
    }
}