class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int numA = A[i];
            List<Integer> indicesA = map.getOrDefault(numA, new ArrayList<Integer>());
            indicesA.add(i + 1);
            map.put(numA, indicesA);
            int numB = B[i];
            List<Integer> indicesB = map.getOrDefault(numB, new ArrayList<Integer>());
            indicesB.add(-i - 1);
            map.put(numB, indicesB);
        }
        int minRotation = Integer.MAX_VALUE;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            List<Integer> indices = map.getOrDefault(key, new ArrayList<Integer>());
            Set<Integer> indicesSet = new HashSet<Integer>();
            for (int index : indices)
                indicesSet.add(Math.abs(index));
            if (indicesSet.size() == length) {
                Collections.sort(indices, new Comparator<Integer>() {
                    public int compare(Integer num1, Integer num2) {
                        return Math.abs(num1) - Math.abs(num2);
                    }
                });
                int countA = 0, countB = 0;
                int size = indices.size();
                for (int i = 0; i < size; i++) {
                    int index = indices.get(i);
                    if (index > 0)
                        countA++;
                    else
                        countB++;
                }
                int curMinRotation = length - Math.max(countA, countB);
                minRotation = Math.min(minRotation, curMinRotation);
            }
        }
        return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
    }
}