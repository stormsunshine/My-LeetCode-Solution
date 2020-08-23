class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        boolean flag = true;
        int length = nums.length;
        while (flag) {
            flag = false;
            for (int i = 0; i < length; i++) {
                if (nums[i] % 2 != 0) {
                    nums[i]--;
                    operations++;
                }
                if (nums[i] > 0) {
                    flag = true;
                    nums[i] /= 2;
                }
            }
            if (flag)
                operations++;
        }
        return operations;
    }
}