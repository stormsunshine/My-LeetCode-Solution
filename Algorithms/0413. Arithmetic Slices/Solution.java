class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int length = A.length;
        int prevDifference = A[1] - A[0];
        List<int[]> slicesList = new ArrayList<int[]>();
        int begin = 0, end = 1;
        for (int i = 2; i < length; i++) {
            int curDifference = A[i] - A[i - 1];
            if (curDifference == prevDifference)
                end = i;
            else {
                if (end - begin >= 2)
                    slicesList.add(new int[]{begin, end});
                begin = i - 1;
                end = i;
            }
            prevDifference = curDifference;
        }
        if (end - begin >= 2)
            slicesList.add(new int[]{begin, end});
        int count = 0;
        for (int[] slice : slicesList) {
            int intervalLength = slice[1] - slice[0];
            int curCount = intervalLength * (intervalLength - 1) / 2;
            count += curCount;
        }
        return count;
    }
}