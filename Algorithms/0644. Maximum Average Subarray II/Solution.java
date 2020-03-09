class Solution {
    public double findMaxAverage(int[] nums, int k) {
        final double EPSILON = 0.00001;
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double prevMid = max;
        double error = Integer.MAX_VALUE;
        while (error > EPSILON) {
            double mid = (min + max) / 2;
            if (exist(nums, mid, k))
                min = mid;
            else
                max = mid;
            error = Math.abs(mid - prevMid);
            prevMid = mid;
        }
        return min;
    }

    public boolean exist(int[] nums, double mid, int k) {
        double sum = 0, prefixSum = 0, minSum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i] - mid;
        if (sum >= 0)
            return true;
        int length = nums.length;
        for (int i = k; i < length; i++) {
            sum += nums[i] - mid;
            prefixSum += nums[i - k] - mid;
            minSum = Math.min(minSum, prefixSum);
            if (sum >= minSum)
                return true;
        }
        return false;
    }
}