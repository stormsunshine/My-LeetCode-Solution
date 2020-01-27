class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int curRemainder = A[i] % K;
            if (curRemainder < 0)
                curRemainder += K;
            sum = (sum + curRemainder) % K;
            int curCount = map.getOrDefault(sum, 0);
            count += curCount;
            map.put(sum, curCount + 1);
        }
        return count;
    }
}