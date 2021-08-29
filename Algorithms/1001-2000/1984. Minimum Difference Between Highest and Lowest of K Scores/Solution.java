class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDifference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = k - 1; i < length; i++) {
            int difference = nums[i] - nums[i - k + 1];
            minDifference = Math.min(minDifference, difference);
        }
        return minDifference;
    }
}