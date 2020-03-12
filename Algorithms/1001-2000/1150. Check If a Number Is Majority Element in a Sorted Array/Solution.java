class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int length = nums.length;
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);
        if (leftIndex < 0 && rightIndex < 0)
            return false;
        else {
            int majorityCount = rightIndex - leftIndex + 1;
            return majorityCount > length / 2;
        }
    }

    public int findLeft(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                if (mid - 1 >= low && nums[mid - 1] == target)
                    high = mid - 1;
                else
                    return mid;
            } else if (num < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -low - 1;
    }

    public int findRight(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                if (mid + 1 <= high && nums[mid + 1] == target)
                    low = mid + 1;
                else
                    return mid;
            } else if (num < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -low - 1;
    }
}