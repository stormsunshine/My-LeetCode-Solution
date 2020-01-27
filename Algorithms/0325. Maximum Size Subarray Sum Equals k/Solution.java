class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum == k)
                maxLength = i + 1;
            else {
                int prevNum = sum - k;
                if (map.containsKey(prevNum)) {
                    int prevIndex = map.get(prevNum);
                    int curLength = i - prevIndex;
                    maxLength = Math.max(maxLength, curLength);
                }
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLength;
    }
}