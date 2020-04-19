class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        int minStart = min >= 0 ? 1 : -min + 1;
        return minStart;
    }
}