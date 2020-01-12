class Solution {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums)
            singleNumber ^= num;
        return singleNumber;
    }
}