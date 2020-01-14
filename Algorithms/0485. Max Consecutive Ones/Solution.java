class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curConsecutiveOnes = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == 1) {
                curConsecutiveOnes++;
                max = Math.max(max, curConsecutiveOnes);
            } else
                curConsecutiveOnes = 0;
        }
        return max;
    }
}