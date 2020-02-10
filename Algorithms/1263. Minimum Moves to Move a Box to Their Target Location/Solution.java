class Solution {
    public int minPushBox(char[][] grid) {
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = grid.length, columns = grid[0].length;
        int[][][][] colors = new int[rows][columns][rows][columns];
        int[][][][] distances = new int[rows][columns][rows][columns];
        for (int bRow = 0; bRow < rows; bRow++) {
            for (int bCol = 0; bCol < columns; bCol++) {
                for (int pRow = 0; pRow < rows; pRow++) {
                    for (int pCol = 0; pCol < columns; pCol++)
                        distances[bRow][bCol][pRow][pCol] = Integer.MAX_VALUE;
                }
            }
        }
        for (int bRow = 0; bRow < rows; bRow++) {
            for (int bCol = 0; bCol < columns; bCol++) {
                for (int pRow = 0; pRow < rows; pRow++) {
                    for (int pCol = 0; pCol < columns; pCol++) {
                        if (grid[bRow][bCol] == '#' || grid[pRow][pCol] == '#') {
                            colors[bRow][bCol][pRow][pCol] = BLOCK;
                            distances[bRow][bCol][pRow][pCol] = -1;
                        }
                    }
                }
            }
        }
        int initialBoxRow = -1, initialBoxColumn = -1, initialPlayerRow = -1, initialPlayerColumn = -1, targetRow = -1, targetColumn = -1;
        int count = 0;
        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char c = grid[i][j];
                if (c == 'B') {
                    initialBoxRow = i;
                    initialBoxColumn = j;
                    count++;
                } else if (c == 'S') {
                    initialPlayerRow = i;
                    initialPlayerColumn = j;
                    count++;
                } else if (c == 'T') {
                    targetRow = i;
                    targetColumn = j;
                    count++;
                }
                if (count == 3)
                    break outer;
            }
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        distances[initialBoxRow][initialBoxColumn][initialPlayerRow][initialPlayerColumn] = 0;
        PriorityQueue<Status> queue = new PriorityQueue<Status>();
        queue.offer(new Status(initialBoxRow, initialBoxColumn, initialPlayerRow, initialPlayerColumn, 0));
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            int boxRow = status.boxRow, boxColumn = status.boxColumn, playerRow = status.playerRow, playerColumn = status.playerColumn, distance = status.distance;
            for (int[] direction : directions) {
                int playerNewRow = playerRow + direction[0], playerNewColumn = playerColumn + direction[1];
                if (playerNewRow < 0 || playerNewRow >= rows || playerNewColumn < 0 || playerNewColumn >= columns || grid[playerNewRow][playerNewColumn] == '#')
                    continue;
                if (playerNewRow == boxRow && playerNewColumn == boxColumn) {
                    int boxNewRow = boxRow + direction[0], boxNewColumn = boxColumn + direction[1];
                    if (boxNewRow < 0 || boxNewRow >= rows || boxNewColumn < 0 || boxNewColumn >= columns || grid[boxNewRow][boxNewColumn] == '#')
                        continue;
                    if (boxNewRow == targetRow && boxNewColumn == targetColumn)
                        return distance + 1;
                    else if (colors[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] == WHITE) {
                        colors[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] = GRAY;
                        distances[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] = distance + 1;
                        queue.offer(new Status(boxNewRow, boxNewColumn, playerNewRow, playerNewColumn, distance + 1));
                    }
                } else {
                    if (colors[boxRow][boxColumn][playerNewRow][playerNewColumn] == WHITE) {
                        colors[boxRow][boxColumn][playerNewRow][playerNewColumn] = GRAY;
                        distances[boxRow][boxColumn][playerNewRow][playerNewColumn] = distance;
                        queue.offer(new Status(boxRow, boxColumn, playerNewRow, playerNewColumn, distance));
                    }
                    
                }
            }
            colors[boxRow][boxColumn][playerRow][playerColumn] = BLACK;
        }
        int totalDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int distance = distances[targetRow][targetColumn][i][j];
                totalDistance = Math.min(totalDistance, distance);
            }
        }
        return totalDistance;
    }
}

class Status implements Comparable<Status> {
	int boxRow;
	int boxColumn;
	int playerRow;
	int playerColumn;
	int distance;

	public Status() {
		
	}

	public Status(int boxRow, int boxColumn, int playerRow, int playerColumn, int distance) {
		this.boxRow = boxRow;
		this.boxColumn = boxColumn;
		this.playerRow = playerRow;
		this.playerColumn = playerColumn;
		this.distance = distance;
	}

	public int compareTo(Status status2) {
		return this.distance - status2.distance;
	}
}