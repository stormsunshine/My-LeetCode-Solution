class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int maxIndex = Math.min(i + k, length - 1);
            for (int j = i + 1; j <= maxIndex; j++) {
                long difference = Math.abs((long) num - (long) nums[j]);
                if (difference <= t)
                    return true;
            }
        }
        return false;
    }
}