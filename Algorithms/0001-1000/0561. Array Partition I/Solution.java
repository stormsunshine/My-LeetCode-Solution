class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i += 2)
            sum += nums[i];
        return sum;
    }
}