class Solution {
    public int heightChecker(int[] heights) {
        int length = heights.length;
        int[] sorted = new int[length];
        System.arraycopy(heights, 0, sorted, 0, length);
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (heights[i] != sorted[i])
                count++;
        }
        return count;
    }
}