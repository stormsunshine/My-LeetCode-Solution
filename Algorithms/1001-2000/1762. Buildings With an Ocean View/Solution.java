class Solution {
    public int[] findBuildings(int[] heights) {
        int length = heights.length;
        boolean[] oceanView = new boolean[length];
        int count = 0;
        int maxHeight = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                oceanView[i] = true;
                count++;
            }
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        int[] buildings = new int[count];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (oceanView[i])
                buildings[index++] = i;
        }
        return buildings;
    }
}