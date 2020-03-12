class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] sorted = new int[length];
        System.arraycopy(nums, 0, sorted, 0, length);
        Arrays.sort(sorted);
        int low = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] != sorted[i]) {
                low = i;
                break;
            }
        }
        if (low < 0)
            return 0;
        int high = length;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] != sorted[i]) {
                high = i;
                break;
            }
        }
        return high - low + 1;
    }
}