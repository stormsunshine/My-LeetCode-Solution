class Solution {
    public int maxSumMinProduct(int[] nums) {
        final int MODULO = 1000000007;
        int length = nums.length;
        long[] prefixSums = new long[length + 1];
        for (int i = 0; i < length; i++)
            prefixSums[i + 1] = prefixSums[i] + (long) nums[i];
        int[] left = new int[length];
        int[] right = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }
        long maxProduct = 0;
        for (int i = 0; i < length; i++) {
            int leftIndex = left[i], rightIndex = right[i];
            long rangeSum = getRangeSum(prefixSums, leftIndex + 1, rightIndex - 1);
            long product = rangeSum * (long) nums[i];
            maxProduct = Math.max(maxProduct, product);
        }
        return (int) (maxProduct % MODULO);
    }

    public long getRangeSum(long[] prefixSums, int start, int end) {
        return prefixSums[end + 1] - prefixSums[start];
    }
}