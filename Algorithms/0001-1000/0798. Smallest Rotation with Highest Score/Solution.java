class Solution {
    public int bestRotation(int[] A) {
        int length = A.length;
        int[] points = new int[length];
        for (int i = 0; i < length; i++) {
            int low = (i - A[i] + 1 + length) % length;
            int high = (i + 1) % length;
            points[low]--;
            points[high]++;
            if (low > high)
                points[0]--;
        }
        int maxIndex = 0;
        int maxScore = -length;
        int curScore = 0;
        for (int i = 0; i < length; i++) {
            curScore += points[i];
            if (curScore > maxScore) {
                maxIndex = i;
                maxScore = curScore;
            }
        }
        return maxIndex;
    }
}