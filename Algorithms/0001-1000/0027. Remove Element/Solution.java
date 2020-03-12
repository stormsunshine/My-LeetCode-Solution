class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int count = 0;
        for (int i = 0, loopIndex = 0; i < length && loopIndex < length; i++, loopIndex++) {
            int num = nums[i];
            if (num != val) {
                count++;
                continue;
            }
            int j = i;
            while (j < length - 1) {
                nums[j] = nums[j + 1];
                j++;
            }
            nums[j] = num;
            i--;
        }
        return count;
    }
}