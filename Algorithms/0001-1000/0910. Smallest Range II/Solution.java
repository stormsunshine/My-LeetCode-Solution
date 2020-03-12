class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int length = A.length;
        int min = A[0], max = A[length - 1];
        int difference = max - min;
        for (int i = 1; i < length; i++) {
            int num1 = A[i - 1], num2 = A[i];
            int high = Math.max(A[length - 1] - K, num1 + K);
            int low = Math.min(A[0] + K, num2 - K);
            difference = Math.min(difference, high - low);
        }
        return difference;
    }
}