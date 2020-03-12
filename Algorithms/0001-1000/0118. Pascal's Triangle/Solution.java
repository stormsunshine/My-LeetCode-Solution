class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return triangle;
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        triangle.add(row1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            int prevSize = i;
            List<Integer> curRow = new ArrayList<Integer>();
            curRow.add(1);
            for (int j = 1; j < i; j++)
                curRow.add(prevRow.get(j - 1) + prevRow.get(j));
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }
}