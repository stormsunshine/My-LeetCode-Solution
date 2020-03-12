class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        int length = heights.length;
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            if (height <= maxHeight)
                continue;
            int curHeight = height;
            for (int j = i; j < length; j++) {
                curHeight = Math.min(curHeight, heights[j]);
                if (curHeight == 0)
                    break;
                int area = (j - i + 1) * curHeight;
                largestArea = Math.max(largestArea, area);
            }
            maxHeight = Math.max(maxHeight, curHeight);
        }
        return largestArea;
    }
}