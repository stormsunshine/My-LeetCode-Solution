class Solution {
    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int[] leftSum = new int[length];
        for (int i = 1; i < length; i++)
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        int[] rightSum = new int[length];
        for (int i = length - 2; i >= 0; i--)
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[i])
                return i;
        }
        return -1;
    }
}