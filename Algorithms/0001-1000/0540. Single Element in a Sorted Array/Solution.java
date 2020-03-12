class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (high - low == 1) {
                if (low == 0)
                    return nums[low];
                else if (high == nums.length - 1)
                    return nums[high];
            }
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num != nums[mid - 1] && num != nums[mid + 1])
                return num;
            else {
                if (mid % 2 == 0 && num == nums[mid + 1] || mid % 2 == 1 && num == nums[mid - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return nums[low];
    }
}