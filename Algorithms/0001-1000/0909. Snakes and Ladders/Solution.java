class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> cellValueMap = new HashMap<Integer, Integer>();
        int sideLength = board.length;
        int cellsCount = sideLength * sideLength;
        int direction = 1;
        int row = sideLength - 1, column = 0;
        for (int i = 1; i <= cellsCount; i++) {
            cellValueMap.put(i, board[row][column]);
            if (i % sideLength == 0) {
                row--;
                direction *= -1;
            } else
                column += direction;
        }
        int moves = 0;
        int[] visits = new int[cellsCount + 1];
        visits[1] = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            moves++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cell = queue.poll();
                int maxCell = Math.min(cell + 6, cellsCount);
                for (int j = cell + 1; j <= maxCell; j++) {
                    if (j == cellsCount)
                        return moves;
                    int value = cellValueMap.get(j);
                    if (value == -1) {
                        if ((visits[j] & 1) == 0) {
                            visits[j]++;
                            queue.offer(j);
                        }
                    } else {
                        if (value == cellsCount)
                            return moves;
                        if ((visits[value] & 2) == 0) {
                            visits[value] += 2;
                            queue.offer(value);
                        }
                    }
                }
            }
        }
        return -1;
    }
}