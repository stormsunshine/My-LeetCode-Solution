class Solution {
    public int countTriplets(int[] A) {
        int tripletsCount = 0;
        int mapLength = 1 << 16;
        int[] map = new int[mapLength];
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                map[A[i] & A[j]]++;
        }
        for (int i = 0; i < mapLength; i++) {
            if (map[i] != 0) {
                for (int j = 0; j < length; j++) {
                    if ((A[j] & i) == 0)
                        tripletsCount += map[i];
                }
            }
        }
        return tripletsCount;
    }
}