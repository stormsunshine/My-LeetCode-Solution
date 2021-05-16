class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        int length = nums.length;
        int count = 1 << length;
        for (int i = 0; i < count; i++) {
            int xor = getXor(nums, i);
            sum += xor;
        }
        return sum;
    }

    public int getXor(int[] nums, int curNum) {
        int xor = 0;
        int index = 0;
        while (curNum > 0) {
            int remainder = curNum % 2;
            if (remainder == 1)
                xor ^= nums[index];
            curNum >>= 1;
            index++;
        }
        return xor;
    }
}