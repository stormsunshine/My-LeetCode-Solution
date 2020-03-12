class Solution {
    public int minTotalDistance(int[][] grid) {
        List<int[]> homesList = new ArrayList<int[]>();
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1)
                    homesList.add(new int[]{i, j});
            }
        }
        int minTotalDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int[] point = {i, j};
                int distance = 0;
                for (int[] home : homesList)
                    distance += manhattanDistance(point, home);
                minTotalDistance = Math.min(minTotalDistance, distance);
            }
        }
        return minTotalDistance;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}