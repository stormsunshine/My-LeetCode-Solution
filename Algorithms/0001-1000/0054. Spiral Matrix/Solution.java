class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return spiralOrder;
        int rows = matrix.length, columns = matrix[0].length;
        int totalCount = rows * columns;
        int visitCount = 0;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        boolean[][] visited = new boolean[rows][columns];
        while (visitCount < totalCount) {
            visited[row][column] = true;
            spiralOrder.add(matrix[row][column]);
            visitCount++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn])
                directionIndex = (directionIndex + 1) % 4;
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return spiralOrder;
    }
}