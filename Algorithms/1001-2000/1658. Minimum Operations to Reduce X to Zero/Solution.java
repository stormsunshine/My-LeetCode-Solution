class Solution {
    public int minOperations(int[] nums, int x) {
        int maxLength = -1;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int length = nums.length;
        int[] prefixSums = new int[length];
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            prefixSums[i] = sum;
            map.put(sum, i);
        }
        int remainSum = sum - x;
        for (int i = 0; i < length; i++) {
            int prefixSum = prefixSums[i];
            if (map.containsKey(prefixSum - remainSum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum - remainSum));
        }
        if (maxLength == -1)
            return -1;
        else
            return length - maxLength;
    }
}