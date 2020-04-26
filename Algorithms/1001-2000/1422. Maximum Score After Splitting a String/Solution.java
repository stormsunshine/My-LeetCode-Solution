class Solution {
    public int maxScore(String s) {
        int length = s.length();
        int ones = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '1')
                ones++;
        }
        int maxScore = 0;
        int leftZeros = 0, rightOnes = ones;
        for (int i = 1; i < length; i++) {
            char lastC = s.charAt(i - 1);
            if (lastC == '0')
                leftZeros++;
            else
                rightOnes--;
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}