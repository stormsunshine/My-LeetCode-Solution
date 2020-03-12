class Solution {
    public int minFlips(int[][] mat) {
        int rows = mat.length, columns = mat[0].length;
        int[][] zeroMatrix = new int[rows][columns];
        String zeroMatrixStr = matrixToString(zeroMatrix);
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        Map<String, Integer> colorMap = new HashMap<String, Integer>();
        Queue<int[][]> queue = new LinkedList<int[][]>();
        queue.offer(mat);
        Queue<Integer> flipsQueue = new LinkedList<Integer>();
        flipsQueue.offer(0);
        String matStr = matrixToString(mat);
        colorMap.put(matStr, GRAY);
        while (!queue.isEmpty()) {
            int[][] curMatrix = queue.poll();
            int flip = flipsQueue.poll();
            String curStr = matrixToString(curMatrix);
            if (zeroMatrixStr.equals(curStr))
                return flip;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int[][] flipMatrix = flip(curMatrix, i, j);
                    String flipStr = matrixToString(flipMatrix);
                    int color = colorMap.getOrDefault(flipStr, WHITE);
                    if (color == WHITE) {
                        queue.offer(flipMatrix);
                        flipsQueue.offer(flip + 1);
                        colorMap.put(flipStr, GRAY);
                    }
                }
            }
            colorMap.put(curStr, BLACK);
        }
        return -1;
    }

    public String matrixToString(int[][] mat) {
		String str = "[";
		int rows = mat.length;
		for (int i = 0; i < rows; i++) {
			int[] row = mat[i];
			String rowStr = Arrays.toString(row);
			if (i > 0)
				str += ", ";
			str += rowStr;
		}
		str += "]";
		return str;
	}

    public int[][] flip(int[][] mat, int row, int column) {
        int rows = mat.length, columns = mat[0].length;
        int[][] flipMat = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                flipMat[i][j] = mat[i][j];
        }
        flipMat[row][column] = 1 - flipMat[row][column];
        if (row > 0)
            flipMat[row - 1][column] = 1 - flipMat[row - 1][column];
        if (row < rows - 1)
            flipMat[row + 1][column] = 1 - flipMat[row + 1][column];
        if (column > 0)
            flipMat[row][column - 1] = 1 - flipMat[row][column - 1];
        if (column < columns - 1)
            flipMat[row][column + 1] = 1 - flipMat[row][column + 1];
        return flipMat;
    }
}