class Solution {
    public int maxChunksToSorted(int[] arr) {
        int curMax = 0;
        int chunksCount = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curMax == i)
                chunksCount++;
        }
        return chunksCount;
    }
}