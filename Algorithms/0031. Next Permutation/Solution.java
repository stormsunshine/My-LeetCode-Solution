class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = -1;
        int curNum = -1;
        for (int i = length - 1; i > 0; i--) {
            int difference = nums[i] - nums[i - 1];
            if (difference > 0) {
                index = i - 1;
                curNum = nums[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(nums);
            return;
        }
        int nextIndex = -1;
        int nextNum = Integer.MAX_VALUE;
        for (int i = index + 1; i < length; i++) {
            if (nums[i] > curNum && nums[i] < nextNum) {
                nextIndex = i;
                nextNum = nums[i];
            }
        }
        nums[index] = nextNum;
        nums[nextIndex] = curNum;
        Arrays.sort(nums, index + 1, length);
    }
}