class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }
}