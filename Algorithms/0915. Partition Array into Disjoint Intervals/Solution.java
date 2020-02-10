class Solution {
    public int partitionDisjoint(int[] A) {
        int length = A.length;
        int[] minRight = new int[length];
        minRight[length - 1] = A[length - 1];
        for (int i = length - 2; i >= 0; i--)
            minRight[i] = Math.min(minRight[i + 1], A[i]);
        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            maxLeft = Math.max(maxLeft, A[i]);
            if (maxLeft <= minRight[i + 1])
                return i + 1;
        }
        return length - 1;
    }
}