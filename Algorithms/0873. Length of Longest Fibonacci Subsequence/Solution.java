class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int length = A.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; i++)
            set.add(A[i]);
        int longestLength = 0;
        int end1 = length - 2, end2 = length - 1;
        for (int i = 0; i < end1; i++) {
            for (int j = i + 1; j < end2; j++) {
                int num1 = A[i];
                int num2 = A[j];
                int curLength = 2;
                while (set.contains(num1 + num2)) {
                    int num3 = num1 + num2;
                    curLength++;
                    num1 = num2;
                    num2 = num3;
                }
                if (curLength >= 3)
                    longestLength = Math.max(longestLength, curLength);
            }
        }
        return longestLength;
    }
}