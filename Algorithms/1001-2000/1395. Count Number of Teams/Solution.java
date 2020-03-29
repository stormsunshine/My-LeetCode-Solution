class Solution {
    public int numTeams(int[] rating) {
        return numTeams(rating, true) + numTeams(rating, false);
    }

    public int numTeams(int[] rating, boolean increase) {
        int teams = 0;
        int length = rating.length;
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                boolean flag = increase ? rating[i] > rating[j] : rating[i] < rating[j];
                if (flag) {
                    dp[i]++;
                    if (dp[j] > 0)
                        teams += dp[j];
                }
            }
        }
        return teams;
    }
}