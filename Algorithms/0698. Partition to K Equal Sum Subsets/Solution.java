class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;
        int subsum = sum / k;
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[length - 1] > subsum)
            return false;
        boolean[] used = new boolean[length];
        return backtrack(nums, k, subsum, 0, 0, used);
    }

    private boolean backtrack(int[] nums, int k, int subsum, int cur, int start, boolean[] used) {
        if (k == 0)
            return true;
        if (cur == subsum)
            return backtrack(nums, k - 1, subsum, 0, 0, used);
        int length = nums.length;
        for (int i = start; i < length; i++) {
            if (!used[i] && nums[i] + cur <= subsum) {
                used[i] = true;
                if (backtrack(nums, k, subsum, nums[i] + cur, i + 1, used))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
}