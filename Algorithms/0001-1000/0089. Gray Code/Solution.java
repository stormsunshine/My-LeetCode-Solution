class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> grayCodeList = new ArrayList<Integer>();
        if (n == 0) {
            grayCodeList.add(0);
            return grayCodeList;
        }
        grayCodeList.add(0);
        grayCodeList.add(1);
        for (int i = 2; i <= n; i++) {
            int power2 = (int) Math.pow(2, i - 1);
            int size = grayCodeList.size();
            for (int j = size - 1; j >= 0; j--) {
                int prevNum = grayCodeList.get(j);
                int curNum = prevNum + power2;
                grayCodeList.add(curNum);
            }
        }
        return grayCodeList;
    }
}