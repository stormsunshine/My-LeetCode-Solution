class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < length) {
            nums[index] = 0;
            index++;
        }
    }
}