class Solution {
    final int WATER = -1;
	final int WHITE = 0;
	final int GRAY = 1;
	final int BLACK = 2;
	int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int numDistinctIslands(int[][] grid) {
		int rows = grid.length, columns = grid[0].length;
		int[][] colors = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 0)
					colors[i][j] = WATER;
			}
		}
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (colors[i][j] == WHITE) {
					int[] position = {i, j};
					String shape = breadthFirstSearch(colors, position);
					set.add(shape);
				}
			}
		}
        return set.size();
    }

	public String breadthFirstSearch(int[][] colors, int[] position) {
		List<String> shapeList = new ArrayList<String>();
		int rows = colors.length, columns = colors[0].length;
		int startRow = position[0], startColumn = position[1];
		Queue<int[]> queue = new LinkedList<int[]>();
		colors[startRow][startColumn] = GRAY;
		queue.offer(position);
		while (!queue.isEmpty()) {
			int[] curPosition = queue.poll();
			int curRow = curPosition[0], curColumn = curPosition[1];
			int[] relativePosition = {curRow - startRow, curColumn - startColumn};
			shapeList.add(Arrays.toString(relativePosition));
			for (int[] direction : directions) {
				int newRow = curRow + direction[0], newColumn = curColumn + direction[1];
				if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && colors[newRow][newColumn] == WHITE) {
					int[] newPosition = {newRow, newColumn};
					colors[newRow][newColumn] = GRAY;
					queue.offer(newPosition);
				}
			}
			colors[curRow][curColumn] = BLACK;
		}
		return shapeList.toString();
	}
}