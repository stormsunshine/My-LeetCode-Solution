class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ans[0] = map.size();
        for (int i = k; i < n; i++) {
            int prev = nums[i - k], curr = nums[i];
            map.put(prev, map.get(prev) - 1);
            if (map.get(prev) == 0)
                map.remove(prev);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            ans[i - k + 1] = map.size();
        }
        return ans;
    }
}