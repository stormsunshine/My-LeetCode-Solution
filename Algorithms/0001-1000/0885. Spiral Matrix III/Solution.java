class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int cells = R * C;
        int[][] order = new int[cells][2];
        order[0][0] = r0;
        order[0][1] = c0;
        int count = 1, fillCount = 1;
        int[] currentCell = new int[2];
        currentCell[0] = r0;
        currentCell[1] = c0;
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        while (fillCount < cells) {
            int step = (count + 1) / 2;
            int[] direction = directions[(count - 1) % 4];
            for (int i = 0; i < step; i++) {
            	for (int j = 0; j < 2; j++)
            		currentCell[j] += direction[j];
            	if (currentCell[0] >= 0 && currentCell[0] < R && currentCell[1] >= 0 && currentCell[1] < C) {
                    for (int j = 0; j < 2; j++)
                        order[fillCount][j] = currentCell[j];
                    fillCount++;
                }
            }
            count++;
        }
        return order;
    }
}