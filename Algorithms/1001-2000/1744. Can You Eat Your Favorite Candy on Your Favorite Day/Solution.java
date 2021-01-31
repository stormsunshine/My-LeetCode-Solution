class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int length = candiesCount.length;
        long[] prefixSums = new long[length + 1];
        for (int i = 0; i < length; i++)
            prefixSums[i + 1] = prefixSums[i] + candiesCount[i];
        int queriesCount = queries.length;
        boolean[] answer = new boolean[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int type = queries[i][0], day = queries[i][1], capacity = queries[i][2];
            long minCandies = prefixSums[type] + 1, maxCandies = prefixSums[type + 1];
            long minPossible = day + 1;
            long maxPossible = (long) (day + 1) * capacity;
            answer[i] = minCandies <= maxPossible && maxCandies >= minPossible;
        }
        return answer;
    }
}