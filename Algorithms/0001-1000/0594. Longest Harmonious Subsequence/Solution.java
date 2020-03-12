class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = numCountMap.getOrDefault(num, 0);
            count++;
            numCountMap.put(num, count);
        }
        int longest = 0;
        Set<Integer> numsSet = numCountMap.keySet();
        for (int num : numsSet) {
            int prevNum = num - 1, nextNum = num + 1;
            if (!numsSet.contains(prevNum) && !numsSet.contains(nextNum))
                continue;
            int curLength = numCountMap.get(num);
            if (numsSet.contains(prevNum)) {
                int length = curLength + numCountMap.get(prevNum);
                longest = Math.max(longest, length);
            }
            if (numsSet.contains(nextNum)) {
                int length = curLength + numCountMap.get(nextNum);
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}