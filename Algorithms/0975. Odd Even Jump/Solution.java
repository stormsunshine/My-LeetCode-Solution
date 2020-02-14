class Solution {
    public int oddEvenJumps(int[] A) {
        int length = A.length;
        boolean[] oddJumps = new boolean[length];
        boolean[] evenJumps = new boolean[length];
        oddJumps[length - 1] = true;
        evenJumps[length - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(A[length - 1], length - 1);
        for (int i = length - 2; i >= 0; i--) {
            int key = A[i];
            if (map.containsKey(key)) {
                int index = map.get(key);
                oddJumps[i] = evenJumps[index];
                evenJumps[i] = oddJumps[index];
            } else {
                Integer lowerKey = map.lowerKey(key);
                Integer higherKey = map.higherKey(key);
                if (lowerKey != null) {
                    int lowerKeyIndex = map.get(lowerKey);
                    evenJumps[i] = oddJumps[lowerKeyIndex];
                }
                if (higherKey != null) {
                    int higherKeyIndex = map.get(higherKey);
                    oddJumps[i] = evenJumps[higherKeyIndex];
                }
            }
            map.put(key, i);
        }
        int goodStartCount = 0;
        for (int i = 0; i < length; i++) {
            if (oddJumps[i])
                goodStartCount++;
        }
        return goodStartCount;
    }
}