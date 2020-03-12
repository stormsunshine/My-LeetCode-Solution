class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] != interval2[0])
                    return interval1[0] - interval2[0];
                else
                    return interval1[1] - interval2[1];
            }
        });
        int eraseCount = 0;
        int prev = 0;
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1])
                    prev = i;
                eraseCount++;
            } else
                prev = i;
        }
        return eraseCount;
    }
}