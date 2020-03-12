class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0)
            return false;
        int sideLength = sum / 4;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, 0, 0, sideLength, 0);
    }

    public boolean backtrack(int[] nums, boolean[] used, int index, int sides, int sideLength, int curSideLength) {
        if (sides == 4)
            return true;
        int length = nums.length;
        boolean flag = false;
        for (int i = index; i < length; i++) {
            if (!used[i]) {
                int num = nums[i];
                int curSum = curSideLength + num;
                if (curSum <= sideLength) {
                    used[i] = true;
                    if (curSum == sideLength)
                        flag = flag || backtrack(nums, used, 0, sides + 1, sideLength, 0);
                    else
                        flag = flag || backtrack(nums, used, i + 1, sides, sideLength, curSum);
                    if (flag)
                        break;
                    used[i] = false;
                }
            }
        }
        return flag;
    }
}