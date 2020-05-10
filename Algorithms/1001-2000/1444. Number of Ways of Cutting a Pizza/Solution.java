class Solution {
    Map<String, Integer> map = new HashMap<String, Integer>();
    final static int MODULO = 1000000007;

    public int ways(String[] pizza, int k) {
        if (pizza == null || pizza.length == 0 || pizza[0].length() == 0)
            return 0;
        int rows = pizza.length, columns = pizza[0].length();
        int[][] counts = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String row = pizza[i];
            for (int j = 0; j < columns; j++)
                counts[i][j] = row.charAt(j) == 'A' ? 1 : 0;
        }
        for (int i = 1; i < columns; i++)
            counts[0][i] += counts[0][i - 1];
        for (int i = 1; i < rows; i++)
            counts[i][0] += counts[i - 1][0];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++)
                counts[i][j] += counts[i - 1][j] + counts[i][j - 1] - counts[i - 1][j - 1];
        }
        int ways = backtrack(counts, 0, 0, k, counts[rows - 1][columns - 1]);
        return ways;
    }

    public int backtrack(int[][] counts, int row, int column, int k, int apples) {
        if (apples < k)
            return 0;
        int rows = counts.length, columns = counts[0].length;
        if (k == 1)
            return apples > 0 ? 1 : 0;
        else {
            String key = Arrays.toString(new int[]{row, column, k});
            if (map.containsKey(key))
                return map.get(key);
            int ways = 0;
            int totalApples = counts[rows - 1][columns - 1];
            for (int i = row + 1; i < rows; i++) {
                int curApples = counts[i - 1][columns - 1];
                int curDifference = 0;
                if (row > 0)
                    curDifference += counts[row - 1][columns - 1];
                if (column > 0)
                    curDifference += counts[i - 1][column - 1];
                if (row > 0 && column > 0)
                    curDifference -= counts[row - 1][column - 1];
                if (curApples > curDifference && curApples < totalApples)
                    ways = (ways + backtrack(counts, i, column, k - 1, apples - (curApples - curDifference))) % MODULO;
            }
            for (int j = column + 1; j < columns; j++) {
                int curApples = counts[rows - 1][j - 1];
                int curDifference = 0;
                if (row > 0)
                    curDifference += counts[row - 1][j - 1];
                if (column > 0)
                    curDifference += counts[rows - 1][column - 1];
                if (row > 0 && column > 0)
                    curDifference -= counts[row - 1][column - 1];
                if (curApples > curDifference && curApples < totalApples)
                    ways = (ways + backtrack(counts, row, j, k - 1, apples - (curApples - curDifference))) % MODULO;
            }
            map.put(Arrays.toString(new int[]{row, column, k}), ways);
            return ways;
        }
    }
}