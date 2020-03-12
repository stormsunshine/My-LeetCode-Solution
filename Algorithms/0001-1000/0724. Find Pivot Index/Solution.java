class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int sum = 0;
        for (int num : nums)
            sum += num;
        int length = nums.length;
        int leftSum = 0, rightSum = sum - nums[0];
        if (leftSum == rightSum)
            return 0;
        for (int i = 1; i < length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
}