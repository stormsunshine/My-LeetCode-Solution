class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int prevIndex = map.getOrDefault(num, -1);
            if (prevIndex >= 0 && i - prevIndex <= k)
                return true;
            map.put(num, i);
        }
        return false;
    }
}