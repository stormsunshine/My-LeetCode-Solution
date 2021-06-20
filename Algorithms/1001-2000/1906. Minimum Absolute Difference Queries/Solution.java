class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int length = nums.length;
        int[] counts = new int[101];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            counts[num]++;
            int[] copy = new int[101];
            System.arraycopy(counts, 0, copy, 0, 101);
            map.put(i, copy);
        }
        int queriesCount = queries.length;
        int[] ans = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int[] query = queries[i];
            int[] rangeCounts = getRangeCounts(map, query[0], query[1]);
            int curMin = Integer.MAX_VALUE;
            int prev = -1;
            for (int j = 1; j <= 100; j++) {
                if (rangeCounts[j] > 0) {
                    if (prev > 0) {
                        int diff = j - prev;
                        curMin = Math.min(curMin, diff);
                    }
                    prev = j;
                }
            }
            ans[i] = curMin == Integer.MAX_VALUE ? -1 : curMin;
        }
        return ans;
    }

    public int[] getRangeCounts(Map<Integer, int[]> map, int start, int end) {
        int[] endCounts = map.get(end);
        if (start == 0)
            return endCounts;
        int[] prevCounts = map.get(start - 1);
        int[] rangeCounts = new int[101];
        for (int i = 0; i <= 100; i++)
            rangeCounts[i] = endCounts[i] - prevCounts[i];
        return rangeCounts;
    }
}