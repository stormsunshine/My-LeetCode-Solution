class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            int curCount = map.getOrDefault(sum - k, 0);
            count += curCount;
            int sumCount = map.getOrDefault(sum, 0);
            map.put(sum, sumCount + 1);
        }
        return count;
    }
}