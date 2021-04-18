class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int prev = nums[i - 1], curr = nums[i];
            int minCurr = Math.max(prev + 1, curr);
            operations += minCurr - curr;
            nums[i] = minCurr;
        }
        return operations;
    }
}