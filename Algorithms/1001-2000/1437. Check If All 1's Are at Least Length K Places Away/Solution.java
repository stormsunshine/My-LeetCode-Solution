class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0)
            return true;
        int length = nums.length;
        int prevOneIndex = -k - 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                if (i - prevOneIndex <= k)
                    return false;
                prevOneIndex = i;
            }
        }
        return true;
    }
}