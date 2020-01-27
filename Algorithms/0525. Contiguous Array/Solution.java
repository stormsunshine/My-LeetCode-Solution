class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLength = 0;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i] == 1 ? 1 : -1;
            counter += num;
            if (counter == 0)
                maxLength = i + 1;
            else {
                if (map.containsKey(counter)) {
                    int prevIndex = map.get(counter);
                    int curLength = i - prevIndex;
                    maxLength = Math.max(maxLength, curLength);
                }
            }
            if (!map.containsKey(counter))
                map.put(counter, i);
        }
        return maxLength;
    }
}