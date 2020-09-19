class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++)
            sum = (sum + nums[i]) % p;
        if (sum == 0)
            return 0;
        int remainder = sum;
        sum = 0;
        int minLength = length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            sum = (sum + nums[i]) % p;
            int prev = (sum - remainder + p) % p;
            if (map.containsKey(prev)) {
                int curLength = i - map.get(prev);
                minLength = Math.min(minLength, curLength);
            }
            map.put(sum, i);
        }
        return minLength == length ? -1 : minLength;
    }
}