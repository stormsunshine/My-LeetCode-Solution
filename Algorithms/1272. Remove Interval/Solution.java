class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int length = intervals.length;
        int removeBegin = toBeRemoved[0], removeEnd = toBeRemoved[1];
        int[] remove = new int[length];
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            if (interval[1] <= removeBegin || interval[0] >= removeEnd)
                remove[i] = 0;
            else if (interval[0] >= removeBegin && interval[1] <= removeEnd)
                remove[i] = 1;
            else if (interval[0] < removeBegin && interval[1] > removeEnd)
                remove[i] = 2;
            else if (interval[0] < removeBegin && interval[1] > removeBegin)
                remove[i] = 3;
            else if (interval[0] < removeEnd && interval[1] > removeEnd)
                remove[i] = 4;
        }
        List<List<Integer>> remainIntervals = new ArrayList<List<Integer>>();
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            int removeStatus = remove[i];
            if (removeStatus == 0) {
                List<Integer> intervalList = new ArrayList<Integer>();
                intervalList.add(interval[0]);
                intervalList.add(interval[1]);
                remainIntervals.add(intervalList);
            } else if (removeStatus == 2) {
                List<Integer> intervalList1 = new ArrayList<Integer>();
                intervalList1.add(interval[0]);
                intervalList1.add(removeBegin);
                remainIntervals.add(intervalList1);
                List<Integer> intervalList2 = new ArrayList<Integer>();
                intervalList2.add(removeEnd);
                intervalList2.add(interval[1]);
                remainIntervals.add(intervalList2);
            } else if (removeStatus == 3) {
                List<Integer> intervalList = new ArrayList<Integer>();
                intervalList.add(interval[0]);
                intervalList.add(removeBegin);
                remainIntervals.add(intervalList);
            } else if (removeStatus == 4) {
                List<Integer> intervalList = new ArrayList<Integer>();
                intervalList.add(removeEnd);
                intervalList.add(interval[1]);
                remainIntervals.add(intervalList);
            }
        }
        return remainIntervals;
    }
}