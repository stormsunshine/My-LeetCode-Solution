class Solution {
    public int waysToMakeFair(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 1;
        if (length == 2)
            return 0;
        int[] evenPrefixSums = new int[length];
        int[] oddPrefixSums = new int[length];
        int[] evenPostfixSums = new int[length];
        int[] oddPostfixSums = new int[length];
        evenPrefixSums[0] = evenPrefixSums[1] = nums[0];
        oddPrefixSums[1] = nums[1];
        for (int i = 2; i < length; i++) {
            int num = nums[i];
            if (i % 2 == 0) {
                evenPrefixSums[i] = evenPrefixSums[i - 1] + num;
                oddPrefixSums[i] = oddPrefixSums[i - 1];
            } else {
                evenPrefixSums[i] = evenPrefixSums[i - 1];
                oddPrefixSums[i] = oddPrefixSums[i - 1] + num;
            }
        }
        if (length % 2 == 0) {
            oddPostfixSums[length - 1] = oddPostfixSums[length - 2] = nums[length - 1];
            evenPostfixSums[length - 2] = nums[length - 2];
        } else {
            evenPostfixSums[length - 1] = evenPostfixSums[length - 2] = nums[length - 1];
            oddPostfixSums[length - 2] = nums[length - 2];
        }
        for (int i = length - 3; i >= 0; i--) {
            int num = nums[i];
            if (i % 2 == 0) {
                evenPostfixSums[i] = evenPostfixSums[i + 1] + num;
                oddPostfixSums[i] = oddPostfixSums[i + 1];
            } else {
                evenPostfixSums[i] = evenPostfixSums[i + 1];
                oddPostfixSums[i] = oddPostfixSums[i + 1] + num;
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            int leftEven = i == 0 ? 0 : evenPrefixSums[i - 1];
            int leftOdd = i == 0 ? 0 : oddPrefixSums[i - 1];
            int rightEven = i == length - 1 ? 0 : oddPostfixSums[i + 1];
            int rightOdd = i == length - 1 ? 0 : evenPostfixSums[i + 1];
            if (leftEven + rightEven == leftOdd + rightOdd)
                count++;
        }
        return count;
    }
}