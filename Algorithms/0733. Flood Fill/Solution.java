class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        if (newColor == prevColor)
            return image;
        int rows = image.length, columns = image[0].length;
        int[][] newImage = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                newImage[i][j] = image[i][j];
        }
        newImage[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int row = pixel[0], column = pixel[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && newImage[newRow][newColumn] == prevColor) {
                    newImage[newRow][newColumn] = newColor;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return newImage;
    }
}