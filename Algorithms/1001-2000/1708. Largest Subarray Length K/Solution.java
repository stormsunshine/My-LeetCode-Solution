class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int maxStart = nums.length - k;
        int maxNum = nums[0], maxIndex = 0;
        for (int i = 1; i <= maxStart; i++) {
            int num = nums[i];
            if (num > maxNum) {
                maxNum = num;
                maxIndex = i;
            }
        }
        int[] subarray = new int[k];
        System.arraycopy(nums, maxIndex, subarray, 0, k);
        return subarray;
    }
}