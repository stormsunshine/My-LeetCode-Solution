class Solution {
    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        int[] maxLeft = new int[length];
        maxLeft[0] = arr[0];
        for (int i = 1; i < length; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        int[] minRight = new int[length];
        minRight[length - 1] = arr[length - 1];
        for (int i = length - 2; i >= 0; i--)
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        int chunksCount = 0;
        int max = -1;
        for (int i = 0; i < length; i++) {
            int curMax = maxLeft[i], curMin = minRight[i];
            if (curMin >= max)
                chunksCount++;
            max = Math.max(max, curMax);
        }
        return chunksCount;
    }
}