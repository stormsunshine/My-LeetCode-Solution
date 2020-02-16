class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count1 = 0, count2 = 0;
        int curCount1 = 0, curCount2 = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num <= R)
                curCount1++;
            else {
                count1 += curCount1 * (curCount1 + 1) / 2;
                curCount1 = 0;
            }
            if (num < L)
                curCount2++;
            else {
                count2 += curCount2 * (curCount2 + 1) / 2;
                curCount2 = 0;
            }
        }
        if (curCount1 > 0)
            count1 += curCount1 * (curCount1 + 1) / 2;
        if (curCount2 > 0)
            count2 += curCount2 * (curCount2 + 1) / 2;
        return count1 - count2;
    }
}