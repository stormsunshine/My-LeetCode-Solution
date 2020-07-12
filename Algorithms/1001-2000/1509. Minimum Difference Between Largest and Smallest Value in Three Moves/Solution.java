class Solution {
    public int minDifference(int[] nums) {
        int length = nums.length;
        if (length <= 4)
            return 0;
        Arrays.sort(nums);
        int difference = length - 4;
        int minDifference = nums[length - 1] - nums[0];
        for (int i = difference; i < length; i++)
            minDifference = Math.min(minDifference, nums[i] - nums[i - difference]);
        return minDifference;
    }
}