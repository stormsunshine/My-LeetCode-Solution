class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int length = A.length;
        if (L == M) {
            int[] rightMaxSums = new int[length - M + 1];
            int rightSum = 0;
            for (int i = 0; i < M; i++)
                rightSum += A[length - i - 1];
            rightMaxSums[length - M] = rightSum;
            for (int i = length - M - 1; i >= L; i--) {
                rightSum -= A[i + M];
                rightSum += A[i];
                rightMaxSums[i] = Math.max(rightMaxSums[i + 1], rightSum);
            }
            int maxSum = 0;
            int leftSum = 0;
            for (int i = 0; i < L; i++)
                leftSum += A[i];
            maxSum = leftSum + rightMaxSums[L];
            int end = length - M;
            for (int i = L; i < end; i++) {
                leftSum -= A[i - L];
                leftSum += A[i];
                maxSum = Math.max(maxSum, leftSum + rightMaxSums[i + 1]);
            }
            return maxSum;
        } else {
            int[] rightMaxSums1 = new int[length - M + 1];
            int rightSum1 = 0;
            for (int i = 0; i < M; i++)
                rightSum1 += A[length - i - 1];
            rightMaxSums1[length - M] = rightSum1;
            for (int i = length - M - 1; i >= L; i--) {
                rightSum1 -= A[i + M];
                rightSum1 += A[i];
                rightMaxSums1[i] = Math.max(rightMaxSums1[i + 1], rightSum1);
            }
            int maxSum1 = 0;
            int leftSum1 = 0;
            for (int i = 0; i < L; i++)
                leftSum1 += A[i];
            maxSum1 = leftSum1 + rightMaxSums1[L];
            int end1 = length - M;
            for (int i = L; i < end1; i++) {
                leftSum1 -= A[i - L];
                leftSum1 += A[i];
                maxSum1 = Math.max(maxSum1, leftSum1 + rightMaxSums1[i + 1]);
            }
            int[] rightMaxSums2 = new int[length - L + 1];
            int rightSum2 = 0;
            for (int i = 0; i < L; i++)
                rightSum2 += A[length - i - 1];
            rightMaxSums2[length - L] = rightSum2;
            for (int i = length - L - 1; i >= M; i--) {
                rightSum2 -= A[i + L];
                rightSum2 += A[i];
                rightMaxSums2[i] = Math.max(rightMaxSums2[i + 1], rightSum2);
            }
            int maxSum2 = 0;
            int leftSum2 = 0;
            for (int i = 0; i < M; i++)
                leftSum2 += A[i];
            maxSum2 = leftSum2 + rightMaxSums2[M];
            int end2 = length - L;
            for (int i = M; i < end2; i++) {
                leftSum2 -= A[i - M];
                leftSum2 += A[i];
                maxSum2 = Math.max(maxSum2, leftSum2 + rightMaxSums2[i + 1]);
            }
            return Math.max(maxSum1, maxSum2);
        }
    }
}