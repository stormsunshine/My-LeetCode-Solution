class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int rows = heightMap.length, columns = heightMap[0].length;
        boolean[][] visited = new boolean[rows][columns];
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<Cell>();
        for (int i = 0; i < columns; i++) {
            visited[0][i] = true;
            visited[rows - 1][i] = true;
            priorityQueue.offer(new Cell(0, i, heightMap[0][i]));
            priorityQueue.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
        }
        for (int i = 1; i < rows - 1; i++) {
            visited[i][0] = true;
            visited[i][columns - 1] = true;
            priorityQueue.offer(new Cell(i, 0, heightMap[i][0]));
            priorityQueue.offer(new Cell(i, columns - 1, heightMap[i][columns - 1]));
        }
        int amount = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!priorityQueue.isEmpty()) {
            Cell cell = priorityQueue.poll();
            int row = cell.row, column = cell.column, height = cell.height;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newColumn = column + direction[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (!visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        int cellHeight = heightMap[newRow][newColumn];
                        if (height > cellHeight) {
                            amount += height - cellHeight;
                            priorityQueue.offer(new Cell(newRow, newColumn, height));
                        } else
                            priorityQueue.offer(new Cell(newRow, newColumn, cellHeight));
                    }
                }
            }
        }
        return amount;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int column;
    int height;

    public Cell(int row, int column, int height) {
        this.row = row;
        this.column = column;
        this.height = height;
    }

    public int compareTo(Cell cell2) {
        return this.height - cell2.height;
    }
}