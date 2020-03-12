class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        final int MODULO = 1000000007;
        Arrays.sort(A);
        int length = A.length;
        long[] counts = new long[length];
        Arrays.fill(counts, 1);
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++)
            indexMap.put(A[i], i);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int leftChild = A[j];
                    int rightChild = A[i] / A[j];
                    if (indexMap.containsKey(rightChild)) {
                        int rightIndex = indexMap.get(rightChild);
                        counts[i] = (counts[i] + counts[j] * counts[rightIndex]) % MODULO;
                    }
                }
            }
        }
        long trees = 0;
        for (int i = 0; i < length; i++)
            trees = (trees + counts[i]) % MODULO;
        return (int) trees;
    }
}