class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length, columns = image[0].length;
        int top = x, bottom = x, left = y, right = y;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        image[x][y] = '2';
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], column = cell[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && image[newRow][newColumn] == '1') {
                    image[newRow][newColumn] = '2';
                    top = Math.min(top, newRow);
                    bottom = Math.max(bottom, newRow);
                    left = Math.min(left, newColumn);
                    right = Math.max(right, newColumn);
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}