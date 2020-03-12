class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lines = triangle.size();
        List<Integer> sums = new ArrayList<Integer>();
        List<Integer> lastLine = triangle.get(lines - 1);
        for (int i = 0; i < lines; i++)
            sums.add(lastLine.get(i));
        for (int i = lines - 2; i >= 0; i--) {
            List<Integer> curLine = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int curNum = curLine.get(j);
                int curSum = Math.min(sums.get(0), sums.get(1)) + curNum;
                sums.remove(0);
                sums.add(curSum);
            }
            sums.remove(0);
        }
        return sums.get(0);
    }
}