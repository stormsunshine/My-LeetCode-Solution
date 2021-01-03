class Solution {
    public int waysToSplit(int[] nums) {
        final int MODULO = 1000000007;
        int ways = 0;
        int length = nums.length;
        int[] prefixSums = new int[length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        int sum = prefixSums[length - 1];
        int maxLeft = sum / 3;
        int maxLeftIndex = binarySearchMax(prefixSums, maxLeft);
        for (int i = 0; i <= maxLeftIndex; i++) {
            int leftSum = prefixSums[i];
            int minMid = leftSum * 2, maxMid = (sum + leftSum) / 2;
            int minMidIndex = binarySearchMin(prefixSums, minMid, i + 1);
            int maxMidIndex = binarySearchMax(prefixSums, maxMid);
            if (maxMidIndex >= minMidIndex) {
                int curWays = maxMidIndex - minMidIndex + 1;
                ways = (ways + curWays) % MODULO;
            }
        }
        return ways;
    }

    public int rangeSum(int[] prefixSums, int start, int end) {
        if (start == 0)
            return prefixSums[end];
        else
            return prefixSums[end] - prefixSums[start - 1];
    }

    public int binarySearchMax(int[] prefixSums, int upper) {
        if (prefixSums[0] > upper)
            return -1;
        int low = 0, high = prefixSums.length - 2;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int cur = prefixSums[mid];
            if (cur > upper)
                high = mid - 1;
            else
                low = mid;
        }
        return high;
    }

    public int binarySearchMin(int[] prefixSums, int lower, int startIndex) {
        if (prefixSums[prefixSums.length - 1] < lower)
            return prefixSums.length;
        int low = startIndex, high = prefixSums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int cur = prefixSums[mid];
            if (cur < lower)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}