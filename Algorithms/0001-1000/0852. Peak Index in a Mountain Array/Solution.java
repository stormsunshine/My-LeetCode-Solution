class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;
        for (int i = 1; i < length; i++) {
            if (A[i] < A[i - 1])
                return i - 1;
        }
        return -1;
    }
}