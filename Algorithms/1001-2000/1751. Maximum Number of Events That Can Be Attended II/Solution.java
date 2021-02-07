class Solution {
    public int maxValue(int[][] events, int k) {
        int maxValue = 0;
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] event1, int[] event2) {
                return event1[1] - event2[1];
            }
        });
        int length = events.length;
        int[][] dp = new int[length][k + 1];
        int[] event0 = events[0];
        for (int j = 1; j <= k; j++) {
            dp[0][j] = event0[2];
            maxValue = Math.max(maxValue, dp[0][j]);
        }
        for (int i = 1; i < length; i++) {
            int[] event = events[i];
            int startDay = event[0], value = event[2];
            int prevIndex = binarySearch(events, startDay);
            if (prevIndex < 0) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], value);
                    maxValue = Math.max(maxValue, dp[i][j]);
                }
            } else {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[prevIndex][j - 1] + value);
                    maxValue = Math.max(maxValue, dp[i][j]);
                }
            }
        }
        return maxValue;
    }

    public int binarySearch(int[][] events, int startDay) {
        if (events[0][1] >= startDay)
            return -1;
        int low = 0, high = events.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int endDay = events[mid][1];
            if (endDay >= startDay)
                high = mid - 1;
            else
                low = mid;
        }
        return low;
    }
}