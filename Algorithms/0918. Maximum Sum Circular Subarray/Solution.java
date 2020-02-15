class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int sum = A[0];
        int maxNum = A[0];
        int newMaxSum = A[0], maxSum = A[0];
        int newMinSum = A[0], minSum = A[0];
        int length = A.length;
        for (int i = 1; i < length; i++) {
            sum += A[i];
            maxNum = Math.max(maxNum, A[i]);
            newMaxSum = Math.max(newMaxSum + A[i], A[i]);
            maxSum = Math.max(maxSum, newMaxSum);
            newMinSum = Math.min(newMinSum + A[i], A[i]);
            minSum = Math.min(minSum, newMinSum);
        }
        if (maxNum <= 0)
            return maxNum;
        else
            return Math.max(maxSum, sum - minSum);
    }
}