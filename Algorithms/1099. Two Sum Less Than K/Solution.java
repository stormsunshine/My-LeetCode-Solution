class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length < 2)
            return -1;
        Arrays.sort(A);
        if (A[0] + A[1] >= K)
            return -1;
        int maxSum = Integer.MIN_VALUE;
        int low = 0, high = A.length - 1;
        while (low < high) {
            int sum = A[low] + A[high];
            if (sum >= K)
                high--;
            else {
                maxSum = Math.max(maxSum, sum);
                low++;
            }
        }
        return maxSum;
    }
}