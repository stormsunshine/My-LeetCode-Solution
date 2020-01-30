class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int WALL = 1;
		int rows = maze.length, columns = maze[0].length;
		int[][] distances = new int[rows][columns];
		String[][] paths = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (maze[i][j] == WALL)
					distances[i][j] = -1;
				else
					distances[i][j] = Integer.MAX_VALUE;
			}
		}
		int shortestDistance = Integer.MAX_VALUE;
		String minPath = "impossible";
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int directionsCount = directions.length;
		String[] directionsPath = {"u", "d", "l", "r"};
		PriorityQueue<PositionDistancePath> priorityQueue = new PriorityQueue<PositionDistancePath>();
		distances[ball[0]][ball[1]] = 0;
		paths[ball[0]][ball[1]] = "";
		priorityQueue.offer(new PositionDistancePath(ball[0], ball[1], 0, ""));
		while (!priorityQueue.isEmpty()) {
			PositionDistancePath positionDistancePath = priorityQueue.poll();
			int row = positionDistancePath.getRow(), column = positionDistancePath.getColumn(), distance = positionDistancePath.getDistance();
			String path = positionDistancePath.getPath();
			if (distance > shortestDistance)
				break;
			for (int i = 0; i < directionsCount; i++) {
				int[] direction = directions[i];
                int deltaRow = direction[0], deltaColumn = direction[1];
				String directionPath = directionsPath[i];
				String newPath = path + directionPath;
				int moveCount = 0;
				int stopRow = row, stopColumn = column;
				int curRow = row + deltaRow, curColumn = column + deltaColumn;
				while (curRow >= 0 && curRow < rows && curColumn >= 0 && curColumn < columns && maze[curRow][curColumn] != WALL) {
					moveCount++;
					stopRow = curRow;
					stopColumn = curColumn;
					if (stopRow == hole[0] && stopColumn == hole[1]) {
						int newDistance = distance + moveCount;
						if (minPath.equals("impossible") || newDistance < shortestDistance || newDistance == shortestDistance && newPath.compareTo(minPath) < 0) {
							distances[hole[0]][hole[1]] = newDistance;
							paths[hole[0]][hole[1]] = newPath;
							shortestDistance = Math.min(shortestDistance, newDistance);
							minPath = newPath;
						}
						break;
					}
					curRow = stopRow + deltaRow;
					curColumn = stopColumn + deltaColumn;
				}
				int newDistance = distance + moveCount;
				if (newDistance < distances[stopRow][stopColumn] || (newDistance == distances[stopRow][stopColumn] && (paths[stopRow][stopColumn] == null || newPath.compareTo(paths[stopRow][stopColumn]) < 0))) {
					distances[stopRow][stopColumn] = newDistance;
					paths[stopRow][stopColumn] = newPath;
					priorityQueue.offer(new PositionDistancePath(stopRow, stopColumn, newDistance, newPath));
				}
			}
		}
		return minPath;
    }
}

class PositionDistancePath implements Comparable<PositionDistancePath> {
	private int row;
	private int column;
	private int distance;
	private String path = "";

	public PositionDistancePath() {
		
	}

	public PositionDistancePath(int row, int column, int distance, String path) {
		this.row = row;
		this.column = column;
		this.distance = distance;
		this.path = path;
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

	public String getPath() {
		return path;
	}

	public int compareTo(PositionDistancePath positionDistance2) {
		if (distance != positionDistance2.distance)
			return distance - positionDistance2.distance;
		return path.compareTo(positionDistance2.path);
    }
}