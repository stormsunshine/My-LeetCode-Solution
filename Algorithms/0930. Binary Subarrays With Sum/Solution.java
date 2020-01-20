class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0)
            return 0;
        Map<Integer, Integer> sumCountMap = new HashMap<Integer, Integer>();
        int length = A.length;
        int beginIndex = 0;
        int curSum = A[0];
        for (int i = 1; i < length; i++) {
            if (A[i] == 1) {
                sumCountMap.put(curSum, i - beginIndex);
                curSum++;
                beginIndex = i;
            }
        }
        sumCountMap.put(curSum, length - beginIndex);
        int totalCount = 0;
        sumCountMap.put(0, sumCountMap.getOrDefault(0, 0) + 1);
        if (S == 0) {
            Set<Integer> keySet = sumCountMap.keySet();
            for (int num : keySet) {
                int count = sumCountMap.get(num);
                totalCount += count * (count - 1) / 2;
            }
            return totalCount;
        } else {
            int minSum = A[0], maxSum = curSum;
            int upper = maxSum - S;
            for (int i = 0; i <= upper; i++) {
                int count1 = sumCountMap.get(i), count2 = sumCountMap.get(i + S);
                totalCount += count1 * count2;
            }
            return totalCount;
        }
    }
}