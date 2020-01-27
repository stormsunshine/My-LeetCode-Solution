class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2)
            return false;
        if (k == 0) {
            for (int i = 1; i < length; i++) {
                if (nums[i - 1] == 0 && nums[i] == 0)
                    return true;
            }
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < length; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex > 1)
                    return true;
            } else
                map.put(remainder, i);
        }
        return false;
    }
}