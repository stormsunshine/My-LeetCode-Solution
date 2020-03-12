class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1)
            return 0;
        int product = 1;
        int count = 0;
        int start = 0, end = 0;
        int length = nums.length;
        while (end < length) {
            product *= nums[end];
            while (product >= k) {
                product /= nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}