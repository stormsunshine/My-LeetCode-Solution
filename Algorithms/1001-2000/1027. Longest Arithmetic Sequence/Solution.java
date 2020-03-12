class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null)
            return 0;
        int length = A.length;
        if (length <= 2)
            return length;
        int maxLength = 2;
        Map<Integer, TreeSet<Integer>> numIndicesMap = new HashMap<Integer, TreeSet<Integer>>();
        for (int i = 0; i < length; i++) {
            int num = A[i];
            TreeSet<Integer> indices = numIndicesMap.getOrDefault(num, new TreeSet<Integer>());
            indices.add(i);
            numIndicesMap.put(num, indices);
            if (indices.size() > maxLength)
                maxLength = indices.size();
        }
        for (int i = 0; i < length; i++) {
            int num1 = A[i];
            for (int j = i + 1; j < length; j++) {
                int num2 = A[j];
                int difference = num2 - num1;
                if (difference == 0)
                    continue;
                int curLength = 2;
                int prevIndex = j;
                int prevNum = num2;
                while (true) {
                    int curNum = prevNum + difference;
                    TreeSet<Integer> indices = numIndicesMap.getOrDefault(curNum, new TreeSet<Integer>());
                    Integer curIndex = indices.ceiling(prevIndex);
                    if (curIndex == null)
                        break;
                    curLength++;
                    prevIndex = curIndex;
                    prevNum = curNum;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}