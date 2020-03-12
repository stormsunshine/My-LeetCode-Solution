class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        map.put(0L, 1);
        long prefixSum = 0L;
        for (int num : nums) {
            prefixSum += num;
            Map<Long, Integer> subMap = map.subMap(prefixSum - upper, true, prefixSum - lower, true);
            Set<Long> keySet = subMap.keySet();
            for (long key : keySet) {
                int value = subMap.get(key);
                count += value;
            }
            int curCount = map.getOrDefault(prefixSum, 0) + 1;
            map.put(prefixSum, curCount);
        }
        return count;
    }
}