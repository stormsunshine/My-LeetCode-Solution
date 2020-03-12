class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int start = 0;
        int zerosCount = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num == 0)
                zerosCount++;
            while (zerosCount > K) {
                if (A[start] == 0)
                    zerosCount--;
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}