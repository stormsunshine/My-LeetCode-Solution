class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer n = map.get(nums[i]);
            if (n == null)
                map.put(nums[i], i);
            n = map.get(target - nums[i]);
            if (n != null && n < i) {
                answer[0] = n;
                answer[1] = i;
                return answer;
            }
        }
        return answer;
    }
}
