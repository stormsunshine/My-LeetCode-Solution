class Solution {
    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = nums[nums[i]];
        return array;
    }
}