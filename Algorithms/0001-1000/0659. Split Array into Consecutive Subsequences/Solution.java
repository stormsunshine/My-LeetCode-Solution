class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            if (count > 0) {
                int endCount = endMap.getOrDefault(num, 0);
                if (endCount > 0) {
                    endMap.put(num, endCount - 1);
                    int nextCount = endMap.getOrDefault(num + 1, 0) + 1;
                    endMap.put(num + 1, nextCount);
                } else {
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(num + 1, count1 - 1);
                        countMap.put(num + 2, count2 - 1);
                        int endCount3 = endMap.getOrDefault(num + 3, 0) + 1;
                        endMap.put(num + 3, endCount3);
                    } else
                        return false;
                }
                countMap.put(num, count - 1);
            }
        }
        return true;
    }
}