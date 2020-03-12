class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        int increments = 0;
        Arrays.sort(A);
        int curValue = A[0];
        int length = A.length;
        for (int i = 1; i < length; i++) {
            curValue = Math.max(curValue + 1, A[i]);
            increments += curValue - A[i];
        }
        return increments;
    }
}