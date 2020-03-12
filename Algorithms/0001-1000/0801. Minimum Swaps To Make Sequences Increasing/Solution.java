class Solution {
    public int minSwap(int[] A, int[] B) {
        int countNoSwap = 0, countSwap = 1;
        int length = A.length;
        for (int i = 1; i < length; i++) {
            int curCountNoSwap = Integer.MAX_VALUE, curCountSwap = Integer.MAX_VALUE;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                curCountNoSwap = Math.min(curCountNoSwap, countNoSwap);
                curCountSwap = Math.min(curCountSwap, countSwap + 1);
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                curCountNoSwap = Math.min(curCountNoSwap, countSwap);
                curCountSwap = Math.min(curCountSwap, countNoSwap + 1);
            }
            countNoSwap = curCountNoSwap;
            countSwap = curCountSwap;
        }
        return Math.min(countNoSwap, countSwap);
    }
}