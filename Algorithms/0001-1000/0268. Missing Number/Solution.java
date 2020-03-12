class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        long sum = 0;
        for (int i = 0; i < length; i++)
            sum += (int) nums[i];
        return (int) ((long) length * ((long) length + 1) / 2 - sum);
    }
}