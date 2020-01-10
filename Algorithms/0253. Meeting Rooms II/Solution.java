class Solution {
    public int minMeetingRooms(int[][] intervals) {
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
        Map<Integer, List<int[]>> intervalsMap = new HashMap<Integer, List<int[]>>();
        Map<Integer, Integer> endTimeMap = new HashMap<Integer, Integer>();
        int length = intervals.length;
        int meetingRooms = 1;
        int[] interval0 = intervals[0];
        List<int[]> intervalsList1 = new ArrayList<int[]>();
        intervalsList1.add(interval0);
        intervalsMap.put(1, intervalsList1);
        endTimeMap.put(1, interval0[1]);
        for (int i = 1; i < length; i++) {
            int[] interval = intervals[i];
            int begin = interval[0], end = interval[1];
            boolean flag = false;
            for (int j = 1; j <= meetingRooms; j++) {
                int endTime = endTimeMap.get(j);
                if (endTime <= begin) {
                    List<int[]> intervalsList = intervalsMap.getOrDefault(j, new ArrayList<int[]>());
                    intervalsList.add(interval);
                    intervalsMap.put(j, intervalsList);
                    endTimeMap.put(j, end);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                meetingRooms++;
                List<int[]> intervalsList = intervalsMap.getOrDefault(meetingRooms, new ArrayList<int[]>());
                intervalsList.add(interval);
                intervalsMap.put(meetingRooms, intervalsList);
                endTimeMap.put(meetingRooms, end);
            }
        }
        return meetingRooms;
    }
}