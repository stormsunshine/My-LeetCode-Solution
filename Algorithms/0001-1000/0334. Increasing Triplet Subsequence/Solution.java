class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > secondNum)
                return true;
            else if (num > firstNum)
                secondNum = num;
            else
                firstNum = num;
        }
        return false;
    }
}