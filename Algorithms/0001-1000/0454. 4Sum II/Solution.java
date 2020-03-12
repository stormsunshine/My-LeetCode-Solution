class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<Integer, Integer>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sumAB = A[i] + B[j];
                int countAB = sumCountMap.getOrDefault(sumAB, 0);
                countAB++;
                sumCountMap.put(sumAB, countAB);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sumCD = C[i] + D[j];
                int curCount = sumCountMap.getOrDefault(-sumCD, 0);
                count += curCount;
            }
        }
        return count;
    }
}