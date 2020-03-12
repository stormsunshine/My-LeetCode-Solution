class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, columns = grid[0].length;
        int size = rows * columns;
        k %= size;
        List<List<Integer>> shifted = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++)
            shifted.add(new ArrayList<Integer>());
        int index = (size - k) % size;
        for (int i = 0; i < size; i++) {
            int num = grid[index / columns][index % columns];
            shifted.get(i / columns).add(num);
            index = (index + 1) % size;
        }
        return shifted;
    }
}