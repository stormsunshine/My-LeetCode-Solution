class Solution {
    public int longestMountain(int[] A) {
        int length = A.length;
        int[] ascending = new int[length];
        for (int i = 1; i < length; i++) {
            if (A[i] > A[i - 1])
                ascending[i] = ascending[i - 1] + 1;
        }
        int[] descending = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1])
                descending[i] = descending[i + 1] + 1;
        }
        int longest = 0;
        int start = 1, end = length - 1;
        for (int i = start; i < end; i++) {
            if (ascending[i] > 0 && descending[i] > 0) {
                int mountainLength = ascending[i] + descending[i] + 1;
                longest = Math.max(longest, mountainLength);
            }
        }
        return longest;
    }
}