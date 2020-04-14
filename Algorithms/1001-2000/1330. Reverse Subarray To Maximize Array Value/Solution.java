class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int maxIncrease = 0;
        int sum = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++)
            sum += Math.abs(nums[i - 1] - nums[i]);
        int min = Math.max(nums[0], nums[1]);
        int max = Math.min(nums[0], nums[1]);
        for (int i = 1; i < length; i++) {
            int curMin = Math.min(nums[i - 1], nums[i]), curMax = Math.max(nums[i - 1], nums[i]);
            if (min < curMin)
                maxIncrease = Math.max(maxIncrease, curMin - min);
            if (max > curMax)
                maxIncrease = Math.max(maxIncrease, max - curMax);
            min = Math.min(min, curMax);
            max = Math.max(max, curMin);
        }
        maxIncrease *= 2;
        for (int i = 1; i < length; i++) {
            maxIncrease = Math.max(maxIncrease, Math.abs(nums[i] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
            maxIncrease = Math.max(maxIncrease, Math.abs(nums[length - i - 1] - nums[length - 1]) - Math.abs(nums[length - 1] - nums[length - i - 1]));
        }
        return sum + maxIncrease;
    }
}