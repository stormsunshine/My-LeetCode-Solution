class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        final int MODULO = 1000000007;
        int n = packages.length, m = boxes.length;
        Arrays.sort(packages);
        for (int i = 0; i < m; i++)
            Arrays.sort(boxes[i]);
        long[] packagesPrefixSum = new long[n];
        packagesPrefixSum[0] = packages[0];
        for (int i = 1; i < n; i++)
            packagesPrefixSum[i] = packagesPrefixSum[i - 1] + packages[i];
        long minWasted = Long.MAX_VALUE;
        int maxPackage = packages[n - 1], minPackage = packages[0];
        for (int[] curBoxes : boxes) {
            int count = curBoxes.length;
            if (curBoxes[count - 1] < maxPackage)
                continue;
            int last = -1;
            long totalWasted = 0;
            for (int i = 0; i < count; i++) {
                int box = curBoxes[i];
                if (box < minPackage)
                    continue;
                int index = lastIndex(packages, box);
                long totalSpace = packagesPrefixSum[index] - (last < 0 ? 0 : packagesPrefixSum[last]);
                long wastedSpace = (long) (index - last) * box - totalSpace;
                totalWasted += wastedSpace;
                last = index;
            }
            minWasted = Math.min(minWasted, totalWasted);
        }
        return minWasted == Long.MAX_VALUE ? -1 : (int) (minWasted % MODULO);
    }

    public int lastIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (arr[mid] <= target)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }
}