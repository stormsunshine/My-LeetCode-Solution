class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = length * (length + 1) / 2;
        int actualSum = 0;
        for (int num : nums)
            actualSum += num;
        int mismatch = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                mismatch = nums[i];
                break;
            }
        }
        int difference = sum - actualSum;
        int missing = mismatch + difference;
        int[] ret = {mismatch, missing};
        return ret;
    }
}