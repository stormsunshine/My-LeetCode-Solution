class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - length2), end = Math.min(k, length1);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, maxSubsequence) > 0)
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
        }
        return maxSubsequence;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        if (length <= k)
            return nums;
        int[] subsequence = new int[k];
        if (k == 0)
            return subsequence;
        Stack<Integer> stack = new Stack<Integer>();
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num && remain > 0) {
                stack.pop();
                remain--;
            }
            stack.push(num);
        }
        while (stack.size() > k)
            stack.pop();
        for (int i = k - 1; i >= 0; i--)
            subsequence[i] = stack.pop();
        return subsequence;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        if (length1 == 0)
            return nums2;
        if (length2 == 0)
            return nums1;
        int mergeLength = length1 + length2;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(Arrays.copyOfRange(nums1, index1, length1), Arrays.copyOfRange(nums2, index2, length2)) > 0)
                merged[i] = nums1[index1++];
            else
                merged[i] = nums2[index2++];
        }
        return merged;
    }

    public int compare(int[] nums1, int[] nums2) {
        int length = Math.min(nums1.length, nums2.length);
        for (int i = 0; i < length; i++) {
            int difference = nums1[i] - nums2[i];
            if (difference != 0)
                return difference;
        }
        return nums1.length - nums2.length;
    }
}