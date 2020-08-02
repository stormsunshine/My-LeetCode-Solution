class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        final int MODULO = 1000000007;
        int length1 = nums1.length, length2 = nums2.length;
        long[] dp1 = new long[length1];
        long[] dp2 = new long[length2];
        dp1[0] = nums1[0];
        dp2[0] = nums2[0];
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (index1 > 0)
                dp1[index1] = Math.max(dp1[index1], dp1[index1 - 1] + num1);
            if (index2 > 0)
                dp2[index2] = Math.max(dp2[index2], dp2[index2 - 1] + num2);
            if (num1 == num2) {
                long curMax = Math.max(dp1[index1], dp2[index2]);
                dp1[index1] = curMax;
                dp2[index2] = curMax;
                index1++;
                index2++;
            } else if (num1 < num2)
                index1++;
            else
                index2++;
        }
        while (index1 < length1) {
            if (index1 > 0)
                dp1[index1] = Math.max(dp1[index1], dp1[index1 - 1] + nums1[index1]);
            index1++;
        }
        while (index2 < length2) {
            if (index2 > 0)
                dp2[index2] = Math.max(dp2[index2], dp2[index2 - 1] + nums2[index2]);
            index2++;
        }
        long maxSum = Math.max(dp1[length1 - 1], dp2[length2 - 1]);
        return (int) (maxSum % MODULO);
    }
}