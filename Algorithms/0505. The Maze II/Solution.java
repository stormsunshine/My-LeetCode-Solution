class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        final int WALL = 1;
        int rows = maze.length, columns = maze[0].length;
        int[][] distances = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maze[i][j] == WALL)
                    distances[i][j] = -1;
                else
                    distances[i][j] = Integer.MAX_VALUE;
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        distances[start[0]][start[1]] = 0;
        PriorityQueue<PositionDistance> priorityQueue = new PriorityQueue<PositionDistance>();
        priorityQueue.offer(new PositionDistance(start[0], start[1], 0));
        while (!priorityQueue.isEmpty()) {
            PositionDistance positionDistance = priorityQueue.poll();
            int row = positionDistance.getRow(), column = positionDistance.getColumn(), distance = positionDistance.getDistance();
            if (distance > shortestDistance)
                break;
            for (int[] direction : directions) {
                int moveCount = 0;
                int deltaRow = direction[0], deltaColumn = direction[1];
                int stopRow = row, stopColumn = column;
                int curRow = row + deltaRow, curColumn = column + deltaColumn;
                while (curRow >= 0 && curRow < rows && curColumn >= 0 && curColumn < columns && maze[curRow][curColumn] != WALL) {
                    moveCount++;
                    stopRow = curRow;
                    stopColumn = curColumn;
                    curRow += deltaRow;
                    curColumn += deltaColumn;
                }
                int newDistance = distance + moveCount;
                if (newDistance < distances[stopRow][stopColumn]) {
                    distances[stopRow][stopColumn] = newDistance;
                    priorityQueue.offer(new PositionDistance(stopRow, stopColumn, newDistance));
                }
            }
            shortestDistance = Math.min(shortestDistance, distances[destination[0]][destination[1]]);
        }
        if (distances[destination[0]][destination[1]] == Integer.MAX_VALUE)
            return -1;
        else
            return shortestDistance;
    }
}

class PositionDistance implements Comparable<PositionDistance> {
	private int row;
	private int column;
	private int distance;

	public PositionDistance() {
		
	}

	public PositionDistance(int row, int column, int distance) {
		this.row = row;
		this.column = column;
		this.distance = distance;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getDistance() {
		return distance;
	}

	public int compareTo(PositionDistance positionDistance2) {
		return this.distance - positionDistance2.distance;
	}
}