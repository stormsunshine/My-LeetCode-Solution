class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 1; i <= V; i++)
            update(heights, K);
        return heights;
    }

    public void update(int[] heights, int index) {
        int newIndex = index;
        int minHeight = heights[index];
        for (int i = index - 1; i >= 0; i--) {
            int height = heights[i];
            if (height < minHeight) {
                newIndex = i;
                minHeight = height;
            } else if (height > minHeight)
                break;
        }
        if (newIndex == index) {
            int length = heights.length;
            for (int i = index + 1; i < length; i++) {
                int height = heights[i];
                if (height < minHeight) {
                    newIndex = i;
                    minHeight = height;
                } else if (height > minHeight)
                    break;
            }
        }
        heights[newIndex]++;
    }
}