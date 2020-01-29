class Solution {
    public int findMaximumXOR(int[] nums) {
        int xor = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixSet = new HashSet<Integer>();
            for (int num : nums)
                prefixSet.add(mask & num);
            int temp = xor | (1 << i);
            for (int prefix : prefixSet) {
                if (prefixSet.contains(prefix ^ temp)) {
                    xor = temp;
                    break;
                }
            }
        }
        return xor;
    }
}