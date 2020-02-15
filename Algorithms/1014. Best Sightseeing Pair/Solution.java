class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxLeftScore = A[0] + 0;
        int maxScore = 0;
        int length = A.length;
        for (int i = 1; i < length; i++) {
            int curLeftScore = A[i] + i;
            int curRightScore = A[i] - i;
            int curScore = maxLeftScore + curRightScore;
            maxScore = Math.max(maxScore, curScore);
            maxLeftScore = Math.max(maxLeftScore, curLeftScore);
        }
        return maxScore;
    }
}