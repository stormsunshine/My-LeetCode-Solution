class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int maxSide = (Math.min(rows, columns) + 1) / 2;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3)
                    set.remove(set.first());
            }
        }
        for (int side = 2; side <= maxSide; side++) {
            int rowStart = 0, rowEnd = rows - (side * 2 - 1);
            int columnStart = side - 1, columnEnd = columns - side;
            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    int sum = getSum(grid, i, j, side);
                    set.add(sum);
                    if (set.size() > 3)
                        set.remove(set.first());
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.reverse(list);
        int size = list.size();
        int[] biggest = new int[size];
        for (int i = 0; i < size; i++)
            biggest[i] = list.get(i);
        return biggest;
    }

    public int getSum(int[][] grid, int topRow, int topColumn, int side) {
        int bottomRow = topRow + (side - 1) * 2;
        int sum = grid[topRow][topColumn] + grid[bottomRow][topColumn];
        for (int i = 1; i < side; i++)
            sum += grid[topRow + i][topColumn - i] + grid[topRow + i][topColumn + i];
        for (int i = 1; i < side - 1; i++)
            sum += grid[bottomRow - i][topColumn - i] + grid[bottomRow - i][topColumn + i];
        return sum;
    }
}