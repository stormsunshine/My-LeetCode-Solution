class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (isIncreasing(nums, i))
                return true;
        }
        return false;
    }

    public boolean isIncreasing(int[] nums, int index) {
        int length = nums.length;
        int prev = -1;
        for (int i = 0; i < length; i++) {
            if (i != index) {
                int curr = nums[i];
                if (curr <= prev)
                    return false;
                prev = curr;
            }
        }
        return true;
    }
}