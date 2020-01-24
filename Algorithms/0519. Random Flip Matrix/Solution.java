class Solution {
    int n_rows;
    int n_cols;
    int remaining;
    Map<Integer, Integer> map;
    Random random;

    public Solution(int n_rows, int n_cols) {
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        remaining = n_rows * n_cols;
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public int[] flip() {
        int randNum = random.nextInt(remaining);
        remaining--;
        int index = map.getOrDefault(randNum, randNum);
        int value = map.getOrDefault(remaining, remaining);
        map.put(randNum, value);
        int[] rowColumn = {index / n_cols, index % n_cols};
        return rowColumn;
    }

    public void reset() {
        map.clear();
        remaining = n_rows * n_cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */