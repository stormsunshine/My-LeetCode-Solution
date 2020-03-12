public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int newSum = nums[0], max = nums[0];
        for (int i = 1; i < length; i++) {
            newSum = Math.max(newSum + nums[i], nums[i]);
            max = Math.max(max, newSum);
        }
        return max;
    }
}