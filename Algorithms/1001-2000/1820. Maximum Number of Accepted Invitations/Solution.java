class Solution {
    int maxInvitations = 0;

    public int maximumInvitations(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[] matches = new int[columns];
        Arrays.fill(matches, -1);
        for (int i = 0; i < rows; i++) {
            boolean[] visited = new boolean[columns];
            if (backtrack(grid, i, visited, matches))
                maxInvitations++;
        }
        return maxInvitations;
    }

    public boolean backtrack(int[][] grid, int row, boolean[] visited, int[] matches) {
        int columns = visited.length;
        for (int j = 0; j < columns; j++) {
            if (grid[row][j] == 1 && !visited[j]) {
                visited[j] = true;
                if (matches[j] == -1 || backtrack(grid, matches[j], visited, matches)) {
                    matches[j] = row;
                    return true;
                }
            }
        }
        return false;
    }
}