class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return;
        int length = nums.length;
        k %= length;
        int low = 0, high = length - 1;
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        int low1 = 0, high1 = k - 1, low2 = k, high2 = length - 1;
        while (low1 < high1) {
            int temp = nums[low1];
            nums[low1] = nums[high1];
            nums[high1] = temp;
            low1++;
            high1--;
        }
        while (low2 < high2) {
            int temp = nums[low2];
            nums[low2] = nums[high2];
            nums[high2] = temp;
            low2++;
            high2--;
        }
    }
}