class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> grayCodeList = new ArrayList<Integer>();
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
        List<Integer> permutation = new ArrayList<Integer>();
        int index = grayCodeList.indexOf(start);
        int size = grayCodeList.size();
        for (int i = 0; i < size; i++) {
            permutation.add(grayCodeList.get(index));
            index = (index + 1) % size;
        }
        return permutation;
    }
}