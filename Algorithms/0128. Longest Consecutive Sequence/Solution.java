class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curLength = 0;
                int curNum = num;
                while (set.contains(curNum)) {
                    curLength++;
                    curNum++;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}