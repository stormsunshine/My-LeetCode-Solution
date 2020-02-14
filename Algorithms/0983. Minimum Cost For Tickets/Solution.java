class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] intervals = {1, 7, 30};
        int length = days.length;
        int minDay = days[0], maxDay = days[length - 1];
        Set<Integer> daysSet = new HashSet<Integer>();
        for (int day : days)
            daysSet.add(day);
        int[][] dp = new int[maxDay + 1][4];
        for (int i = minDay; i <= maxDay; i++) {
            for (int j = 0; j < 4; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        for (int i = minDay; i <= maxDay; i++) {
            int prevMin = min(dp[i - 1]);
            if (daysSet.contains(i)) {
                for (int j = 0; j < 3; j++) {
                    int intervalEnd = Math.min(i + intervals[j] - 1, maxDay);
                    int totalCost = prevMin + costs[j];
                    dp[i][j] = totalCost;
                    for (int k = i + 1; k <= intervalEnd; k++)
                        dp[k][3] = Math.min(dp[k][3], totalCost);
                }
            } else {
                for (int j = 0; j < 3; j++)
                    dp[i][j] = prevMin + costs[j];
                dp[i][3] = Math.min(dp[i][3], prevMin);
            }
        }
        return min(dp[maxDay]);
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int num : array)
            min = Math.min(min, num);
        return min;
    }
}