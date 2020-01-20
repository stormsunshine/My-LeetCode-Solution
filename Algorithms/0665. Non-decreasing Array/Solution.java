class Solution {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            int prevNum = nums[i - 1], curNum = nums[i];
            if (prevNum > curNum) {
                if (flag)
                    return false;
                else {
                    if (i > 1 && i < length - 1) {
                        int prev2Num = nums[i - 2], nextNum = nums[i + 1];
                        if (curNum < prev2Num && nextNum < prevNum)
                            return false;
                    }
                    flag = true;
                }
            }
        }
        return true;
    }
}