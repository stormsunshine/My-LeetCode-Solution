class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - 2] * nums[length - 1] - nums[0] * nums[1];
    }
}