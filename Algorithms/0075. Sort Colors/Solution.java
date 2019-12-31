class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            int k = i - 1;
            while (k >= 0 && nums[k] > num) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = num;
        }
    }
}