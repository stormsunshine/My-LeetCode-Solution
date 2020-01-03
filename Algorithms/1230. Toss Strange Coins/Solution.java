class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int length = prob.length;
        double[][] dp = new double[length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            double curProb = prob[i - 1];
            dp[i][0] = dp[i - 1][0] * (1 - curProb);
            for (int j = 1; j <= target; j++)
                dp[i][j] = dp[i - 1][j - 1] * curProb + dp[i - 1][j] * (1 - curProb);
        }
        return dp[length][target];
    }
}