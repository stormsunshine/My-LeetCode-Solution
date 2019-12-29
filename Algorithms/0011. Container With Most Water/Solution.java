class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int containerWidth = right - left;
            int containerHeight = Math.min(height[left], height[right]);
            int containerArea = containerWidth * containerHeight;
            maxArea = Math.max(maxArea, containerArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}