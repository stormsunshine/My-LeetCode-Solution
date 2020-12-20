class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        int start = 0, end = 0;
        while (end < length) {
            int num = nums[end++];
            sum += num;
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            while (map.size() < end - start) {
                int prevNum = nums[start++];
                sum -= prevNum;
                int prevCount = map.get(prevNum) - 1;
                if (prevCount > 0)
                    map.put(prevNum, prevCount);
                else
                    map.remove(prevNum);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}