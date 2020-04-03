class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int slicesCount = 0;
        int length = A.length;
        Map<Long, Integer>[] mapArray = new Map[length];
        for (int i = 0; i < length; i++) {
            mapArray[i] = new HashMap<Long, Integer>();
            for (int j = 0; j < i; j++) {
                long difference = (long) A[i] - (long) A[j];
                if (difference < Integer.MIN_VALUE || difference > Integer.MAX_VALUE)
                    continue;
                int prevCount = mapArray[j].getOrDefault(difference, 0);
                int currCount = mapArray[i].getOrDefault(difference, 0) + prevCount + 1;
                mapArray[i].put(difference, currCount);
                slicesCount += prevCount;
            }
        }
        return slicesCount;
    }
}