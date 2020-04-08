class Solution {
    public int rectangleArea(int[][] rectangles) {
        final int MODULO = 1000000007;
        TreeSet<Integer> xSet = new TreeSet<Integer>();
        long area = 0;
        for (int[] rectangle : rectangles) {
            xSet.add(rectangle[0]);
            xSet.add(rectangle[2]);
        }
        List<Integer> xList = new ArrayList<Integer>(xSet);
        for (int i = xList.size() - 2; i >= 0; i--) {
            List<int[]> yList = new ArrayList<int[]>();
            for (int[] rectangle : rectangles) {
                if (xList.get(i) >= rectangle[0] && xList.get(i + 1) <= rectangle[2]) {
                    int[] interval = {rectangle[1], rectangle[3]};
                    yList = insert(yList, interval);
                }
            }
            long distance = 0;
            for (int[] interval : yList)
                distance += interval[1] - interval[0];
            area = (area + (xList.get(i + 1) - xList.get(i)) * distance) % MODULO;
        }
        return (int) area;
    }

    public List<int[]> insert(List<int[]> intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<int[]>();
        int start = newInterval[0], end = newInterval[1];
        int size = intervals.size();
        boolean inserted = false;
        for (int i = 0; i < size; i++) {
            int[] interval = intervals.get(i);
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
        intervals = new ArrayList<int[]>(intervalsList);
        return intervalsList;
    }
}