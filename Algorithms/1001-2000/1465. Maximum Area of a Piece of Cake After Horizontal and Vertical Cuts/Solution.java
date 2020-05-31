class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int MODULO = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int horizontalLength = horizontalCuts.length, verticalLength = verticalCuts.length;
        int maxHorizontal = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalLength - 1]);
        int maxVertical = Math.max(verticalCuts[0], w - verticalCuts[verticalLength - 1]);
        for (int i = 1; i < horizontalLength; i++) {
            int horizontal = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHorizontal = Math.max(maxHorizontal, horizontal);
        }
        for (int i = 1; i < verticalLength; i++) {
            int vertical = verticalCuts[i] - verticalCuts[i - 1];
            maxVertical = Math.max(maxVertical, vertical);
        }
        long maxArea = (long) maxHorizontal * (long) maxVertical;
        return (int) (maxArea % MODULO);
    }
}