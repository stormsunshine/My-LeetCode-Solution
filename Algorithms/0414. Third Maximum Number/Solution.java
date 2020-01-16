class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            long numLong = (long) num;
            if (numLong == firstMax || numLong == secondMax || numLong == thirdMax)
                continue;
            if (numLong > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = numLong;
                count++;
            } else if (numLong > secondMax) {
                thirdMax = secondMax;
                secondMax = numLong;
                count++;
            } else if (numLong > thirdMax) {
                thirdMax = numLong;
                count++;
            }
        }
        return count >= 3 ? (int) thirdMax : (int) firstMax;
    }
}