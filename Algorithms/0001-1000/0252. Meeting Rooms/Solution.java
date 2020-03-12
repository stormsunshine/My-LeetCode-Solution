class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            int[] prev = intervals[i - 1];
            int[] cur = intervals[i];
            if (prev[1] > cur[0])
                return false;
        }
        return true;
    }
}