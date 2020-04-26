class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int length = cardPoints.length;
        for (int i = 0; i < length; i++)
            sum += cardPoints[i];
        int remain = length - k;
        if (remain <= 0)
            return sum;
        int remainSum = 0;
        for (int i = 0; i < remain; i++)
            remainSum += cardPoints[i];
        int minRemainSum = remainSum;
        for (int i = remain; i < length; i++) {
            remainSum -= cardPoints[i - remain];
            remainSum += cardPoints[i];
            minRemainSum = Math.min(minRemainSum, remainSum);
        }
        return sum - minRemainSum;
    }
}