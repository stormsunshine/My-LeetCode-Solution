class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int length = nums.length;
        int[] leftMax = new int[length];
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++)
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        int[] rightMin = new int[length];
        rightMin[length - 1] = Integer.MAX_VALUE;
        for (int i = length - 2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        int count = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > leftMax[i] && num < rightMin[i])
                count++;
        }
        return count;
    }
}