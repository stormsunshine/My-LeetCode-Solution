class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int highBit = 1 << ((int) (Math.log(high) / Math.log(2)));
        int pairs = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high)
                    pairs++;
                else if (nums[i] < highBit * 2 && nums[j] >= highBit * 2)
                    break;
            }
        }
        return pairs;
    }
}