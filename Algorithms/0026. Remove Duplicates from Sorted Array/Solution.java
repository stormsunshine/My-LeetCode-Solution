class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int index = 1;
        int num = nums[0];
        for (int i = 1; i < length; i++) {
            int curNum = nums[i];
            if (curNum == num)
                continue;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            index++;
            num = curNum;
        }
        return index;
    }
}