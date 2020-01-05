class Solution {
    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0)
            return -1;
        if (A.length == 1)
            return A[0];
        Arrays.sort(A);
        int length = A.length;
        if (A[length - 1] != A[length - 2])
            return A[length - 1];
        for (int i = length - 2; i > 0; i--) {
            int prevNum = A[i - 1], curNum = A[i], nextNum = A[i + 1];
            if (curNum != prevNum && curNum != nextNum)
                return curNum;
        }
        if (A[0] != A[1])
            return A[0];
        else
            return -1;
    }
}