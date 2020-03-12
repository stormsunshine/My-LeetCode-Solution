class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<int[]>();
        int start = newInterval[0], end = newInterval[1];
        int length = intervals.length;
        boolean inserted = false;
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            if (inserted)
                intervalsList.add(interval);
            else {
                if (interval[1] < start)
                    intervalsList.add(interval);
                else if (interval[0] > end) {
                    int[] insertInterval = {start, end};
                    intervalsList.add(insertInterval);
                    intervalsList.add(interval);
                    inserted = true;
                } else {
                    start = Math.min(start, interval[0]);
                    end = Math.max(end, interval[1]);
                }
            }
        }
        if (!inserted) {
            int[] insertInterval = {start, end};
            intervalsList.add(insertInterval);
        }
        int size = intervalsList.size();
        int[][] ret = new int[size][2];
        for (int i = 0; i < size; i++) {
            int[] interval = intervalsList.get(i);
            for (int j = 0; j < 2; j++)
                ret[i][j] = interval[j];
        }
        return ret;
    }
}