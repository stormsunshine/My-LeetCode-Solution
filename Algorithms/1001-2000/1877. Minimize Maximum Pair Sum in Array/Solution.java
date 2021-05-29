class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, sum);
            left++;
            right--;
        }
        return maxSum;
    }
}