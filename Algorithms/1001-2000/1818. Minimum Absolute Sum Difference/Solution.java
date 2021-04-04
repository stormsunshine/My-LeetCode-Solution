class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MODULO = 1000000007;
        TreeSet<Integer> set = new TreeSet<Integer>();
        long sum = 0;
        int length = nums1.length;
        for (int i = 0; i < length; i++) {
            sum += (long) Math.abs(nums1[i] - nums2[i]);
            set.add(nums1[i]);
        }
        long minSum = sum;
        for (int i = 0; i < length; i++) {
            int num2 = nums2[i];
            Integer newNumFloor = set.floor(num2), newNumCeiling = set.ceiling(num2);
            long curSum = sum - (long) Math.abs(nums1[i] - nums2[i]);
            if (newNumFloor != null) {
                long curSumFloor = curSum + (long) Math.abs(newNumFloor - nums2[i]);
                minSum = Math.min(minSum, curSumFloor);
            }
            if (newNumCeiling != null) {
                long curSumCeiling = curSum + (long) Math.abs(newNumCeiling - nums2[i]);
                minSum = Math.min(minSum, curSumCeiling);
            }
        }
        return (int) (minSum % MODULO);
    }
}