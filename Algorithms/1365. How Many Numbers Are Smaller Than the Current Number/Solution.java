class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] sorted = new int[length];
        System.arraycopy(nums, 0, sorted, 0, length);
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1])
                continue;
            else
                map.put(sorted[i], i);
        }
        int[] smaller = new int[length];
        for (int i = 0; i < length; i++)
            smaller[i] = map.get(nums[i]);
        return smaller;
    }
}