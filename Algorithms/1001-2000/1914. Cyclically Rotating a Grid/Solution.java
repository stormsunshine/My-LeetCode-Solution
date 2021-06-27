class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<Integer> order = spiralOrder(grid);
        List<Integer> rotatedOrder = new ArrayList<Integer>();
        int startIndex = 0;
        int layerSize = (m + n - 2) * 2;
        int total = m * n;
        while (startIndex < total) {
            List<Integer> layer = order.subList(startIndex, startIndex + layerSize);
            int curIndex = k % layerSize;
            for (int i = 0; i < layerSize; i++) {
                rotatedOrder.add(layer.get(curIndex));
                curIndex = (curIndex + 1) % layerSize;
            }
            startIndex += layerSize;
            layerSize -= 8;
        }
        return generateGrid(m, n, rotatedOrder);
    }

    public List<Integer> spiralOrder(int[][] grid) {
        List<Integer> order = new ArrayList<Integer>();
        int m = grid.length, n = grid[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++)
                order.add(grid[top][column]);
            for (int row = top + 1; row <= bottom; row++)
                order.add(grid[row][right]);
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--)
                    order.add(grid[bottom][column]);
                for (int row = bottom; row > top; row--)
                    order.add(grid[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public int[][] generateGrid(int m, int n, List<Integer> order) {
        int[][] grid = new int[m][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int size = order.size();
        for (int i = 0; i < size; i++) {
            grid[row][column] = order.get(i);
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || grid[nextRow][nextColumn] != 0)
                directionIndex = (directionIndex + 1) % 4;
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return grid;
    }
}