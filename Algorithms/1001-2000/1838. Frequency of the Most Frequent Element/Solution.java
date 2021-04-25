class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        long[] differences = new long[length];
        for (int i = 1; i < length; i++)
            differences[i] = (long) nums[i] - (long) nums[i - 1];
        long[] prefixSums = new long[length];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + differences[i];
        int low = 1, high = length;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isPossible(nums, differences, prefixSums, mid, k))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    public boolean isPossible(int[] nums, long[] differences, long[] prefixSums, int freq, int k) {
        int length = differences.length;
        long times = 0;
        for (int i = freq - 2; i >= 0; i--)
            times += (long) nums[freq - 1] - (long) nums[i];
        long minTimes = times;
        for (int i = freq; i < length; i++) {
            times = times - (prefixSums[i - 1] - prefixSums[i - freq]) + differences[i] * (freq - 1);
            minTimes = Math.min(minTimes, times);
        }
        return minTimes <= (long) k;
    }
}