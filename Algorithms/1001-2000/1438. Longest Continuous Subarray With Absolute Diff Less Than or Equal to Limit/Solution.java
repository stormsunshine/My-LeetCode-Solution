class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxLength = 0;
        int start = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            while (map.lastKey() - map.firstKey() > limit) {
                int prevNum = nums[start];
                int prevCount = map.get(prevNum) - 1;
                if (prevCount == 0)
                    map.remove(prevNum);
                else
                    map.put(prevNum, prevCount);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}