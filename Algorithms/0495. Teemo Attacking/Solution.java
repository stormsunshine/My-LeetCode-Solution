class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;
        int totalDuration = 0;
        int length = timeSeries.length;
        for (int i = 1; i < length; i++) {
            int prev = timeSeries[i - 1], cur = timeSeries[i];
            totalDuration += Math.min(cur - prev, duration);
        }
        totalDuration += duration;
        return totalDuration;
    }
}