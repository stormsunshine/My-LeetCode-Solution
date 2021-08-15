class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] rearrange = new int[length];
        int left = 0, right = length - 1;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                rearrange[i] = nums[left];
                left++;
            } else {
                rearrange[i] = nums[right];
                right--;
            }
        }
        return rearrange;
    }
}