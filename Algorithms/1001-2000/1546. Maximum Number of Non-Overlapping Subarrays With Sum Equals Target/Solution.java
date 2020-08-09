class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<Integer, TreeSet<Integer>>();
        TreeSet<Integer> set0 = new TreeSet<Integer>();
        set0.add(-1);
        map.put(0, set0);
        int sum = 0;
        int length = nums.length;
        int[] sums = new int[length];
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            sums[i] = sum;
            TreeSet<Integer> set = map.getOrDefault(sum, new TreeSet<Integer>());
            set.add(i);
            map.put(sum, set);
        }
        int maxSubarrays = 0;
        int prevIndex = -1;
        for (int i = 0; i < length; i++) {
            int currSum = sums[i];
            int prevSum = currSum - target;
            if (map.containsKey(prevSum)) {
                TreeSet<Integer> set = map.get(prevSum);
                Integer startIndex = set.ceiling(prevIndex);
                if (startIndex != null && startIndex < i) {
                    maxSubarrays++;
                    prevIndex = i;
                }
            }
        }
        return maxSubarrays;
    }
}