class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        int midPoint = rowIndex / 2;
        for (int i = 0; i <= midPoint; i++)
            row.add(combination(rowIndex, i));
        for (int i = midPoint + 1; i <= rowIndex; i++)
            row.add(row.get(rowIndex - i));
        return row;
    }

    public int combination(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++)
            result = result * (n - k + i) / i;
        return (int) result;
    }
}