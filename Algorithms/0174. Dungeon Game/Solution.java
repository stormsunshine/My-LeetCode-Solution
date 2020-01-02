class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, columns = dungeon[0].length;
        int[][] healths = new int[rows][columns];
        healths[rows - 1][columns - 1] = Math.max(0, -dungeon[rows - 1][columns - 1]) + 1;
        for (int i = rows - 2; i >= 0; i--)
            healths[i][columns - 1] = Math.max(healths[i + 1][columns - 1] - dungeon[i][columns - 1], 1);
        for (int i = columns - 2; i >= 0; i--)
            healths[rows - 1][i] = Math.max(healths[rows - 1][i + 1] - dungeon[rows - 1][i], 1);
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--)
                healths[i][j] = Math.max(Math.min(healths[i + 1][j], healths[i][j + 1]) - dungeon[i][j], 1);
        }
        return healths[0][0];
    }
}