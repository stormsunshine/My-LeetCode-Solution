class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        final int MODULO = 1000000007;
        long maxSubArraySum = maxSubArraySum(arr);
        if (k == 1)
            return (int) (maxSubArraySum % MODULO);
        long sum = 0;
        long maxPrefixSum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            maxPrefixSum = Math.max(maxPrefixSum, sum);
        }
        long postfixSum = 0, maxPostfixSum = 0;
        for (int i = length - 1; i >= 0; i--) {
            postfixSum += arr[i];
            maxPostfixSum = Math.max(maxPostfixSum, postfixSum);
        }
        long maxSum = Math.max(maxSubArraySum, maxPostfixSum + maxPrefixSum);
        if (sum > 0) {
            maxSum = Math.max(maxSum, sum * k);
            maxSum = Math.max(maxSum, maxPostfixSum + sum * (k - 2) + maxPrefixSum);
            maxSum = Math.max(maxSum, Math.max(sum * (k - 1) + maxPrefixSum, maxPostfixSum + sum * (k - 1)));
        }
        return (int) (maxSum % MODULO);
    }

    public long maxSubArraySum(int[] arr) {
        int length = arr.length;
        long newSum = arr[0], max = arr[0];
        for (int i = 1; i < length; i++) {
            newSum = Math.max(newSum + arr[i], arr[i]);
            max = Math.max(max, newSum);
        }
        max = Math.max(max, 0);
        return max;
    }
}