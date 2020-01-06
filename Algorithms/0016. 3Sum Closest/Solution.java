class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int leftStart = 0, leftEnd = length - 3;
        for (int left = leftStart; left <= leftEnd; left++) {
            int leftNum = nums[left];
            if (left > 0 && leftNum == nums[left - 1])
                continue;
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int midNum = nums[mid], rightNum = nums[right];
                int curSum = leftNum + midNum + rightNum;
                if (Math.abs(curSum - target) < Math.abs(sum - target))
                    sum = curSum;
                if (curSum <= target)
                    mid++;
                if (curSum >= target)
                    right--;
            }
        }
        return sum;
    }
}