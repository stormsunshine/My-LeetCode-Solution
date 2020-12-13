class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        int[] leftDifferences = new int[length];
        for (int i = 1; i < length; i++)
            leftDifferences[0] += nums[i] - nums[0];
        for (int i = 1; i < length; i++) {
            int difference = nums[i] - nums[i - 1];
            leftDifferences[i] = leftDifferences[i - 1] - difference - difference * (length - 1 - i);
        }
        int[] rightDifferences = new int[length];
        for (int i = length - 2; i >= 0; i--)
            rightDifferences[length - 1] += nums[length - 1] - nums[i];
        for (int i = length - 2; i >= 0; i--) {
            int difference = nums[i + 1] - nums[i];
            rightDifferences[i] = rightDifferences[i + 1] - difference - difference * i;
        }
        int[] differences = new int[length];
        for (int i = 0; i < length; i++)
            differences[i] = leftDifferences[i] + rightDifferences[i];
        return differences;
    }
}