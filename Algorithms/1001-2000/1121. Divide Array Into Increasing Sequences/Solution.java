class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        if (nums == null || nums.length == 0)
            return false;
        int prevNum = nums[0], count = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num == prevNum)
                count++;
            else {
                prevNum = num;
                count = 1;
            }
            if (count * K > length)
                return false;
        }
        return true;
    }
}