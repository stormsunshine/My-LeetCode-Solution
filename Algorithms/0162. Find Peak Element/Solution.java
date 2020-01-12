class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int length = nums.length;
        if (length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[length - 1] > nums[length - 2])
            return length - 1;
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (mid == 0 || mid == length - 1)
                return mid;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1])
                low = mid;
            else
                high = mid;
        }
        return low;
    }
}