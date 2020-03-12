class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length < 2)
            return length;
        int increaseLength = 1;
        int decreaseLength = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1])
                increaseLength = decreaseLength + 1;
            else if (nums[i] < nums[i - 1])
                decreaseLength = increaseLength + 1;
        }
        return Math.max(increaseLength, decreaseLength);
    }
}