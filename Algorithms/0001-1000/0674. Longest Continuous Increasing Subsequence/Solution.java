class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxLength = 1;
        int increaseLength = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1])
                increaseLength++;
            else {
                maxLength = Math.max(maxLength, increaseLength);
                increaseLength = 1;
            }
        }
        maxLength = Math.max(maxLength, increaseLength);
        return maxLength;
    }
}