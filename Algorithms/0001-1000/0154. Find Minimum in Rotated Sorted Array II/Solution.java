class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.min(nums[0], nums[1]);
        if (nums[0] < nums[length - 1])
            return nums[0];
        return findMin(nums, 0, length - 1);
    }

    public int findMin(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        else if (high - low == 1)
            return Math.min(nums[low], nums[high]);
        int mid = (high - low) / 2 + low;
        return Math.min(findMin(nums, low, mid), findMin(nums, mid + 1, high));
    }
}