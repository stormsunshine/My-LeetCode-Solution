class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (nums[0] < nums[length - 1])
            return nums[0];
        int low = 0, high = length - 1;
        while (low < high) {
            if (high - low == 1)
                return Math.min(nums[low], nums[high]);
            int mid = (high - low) / 2 + low;
            int lowNum = nums[low], midNum = nums[mid];
            if (midNum > lowNum)
                low = mid;
            else
                high = mid;
        }
        return nums[low];
    }
}