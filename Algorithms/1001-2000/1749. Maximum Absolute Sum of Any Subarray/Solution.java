class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sumMax = nums[0], sumMin = nums[0];
        int max = Math.max(sumMax, 0), min = Math.min(sumMin, 0);
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            sumMax = Math.max(sumMax + num, num);
            sumMin = Math.min(sumMin + num, num);
            max = Math.max(max, sumMax);
            min = Math.min(min, sumMin);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}