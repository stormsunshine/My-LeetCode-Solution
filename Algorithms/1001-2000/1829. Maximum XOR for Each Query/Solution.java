class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maximum = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] prefixXors = new int[n];
        prefixXors[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixXors[i] = prefixXors[i - 1] ^ nums[i];
        int[] maximumXors = new int[n];
        for (int i = 0; i < n; i++) {
            int prefixXor = prefixXors[n - 1 - i];
            maximumXors[i] = maximum ^ (maximum & prefixXor);
        }
        return maximumXors;
    }
}