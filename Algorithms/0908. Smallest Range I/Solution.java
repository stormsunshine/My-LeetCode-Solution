class Solution {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int length = A.length;
        int min = A[0], max = A[length - 1];
        int difference = max - min;
        return Math.max(0, difference - 2 * K);
    }
}