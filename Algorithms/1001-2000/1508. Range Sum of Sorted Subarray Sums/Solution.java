class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int sumsLength = length * (length + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int rangeSum = 0;
        for (int i = left - 1; i < right; i++)
            rangeSum = (rangeSum + sums[i]) % MODULO;
        return rangeSum;
    }
}