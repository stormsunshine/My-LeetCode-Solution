class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] != interval2[0])
                    return interval1[0] - interval2[0];
                else
                    return interval1[1] - interval2[1];
            }
        });
        int length = intervals.length;
        Stack<int[]> stack = new Stack<int[]>();
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            if (stack.isEmpty())
                stack.push(interval);
            else {
                int[] prevInterval = stack.peek();
                if (interval[0] > prevInterval[1])
                    stack.push(interval);
                else if (interval[1] > prevInterval[1]) {
                    stack.pop();
                    int[] newInterval = {prevInterval[0], interval[1]};
                    stack.push(newInterval);
                }
            }
        }
        int remainIntervals = stack.size();
        int[][] mergedIntervals = new int[remainIntervals][2];
        for (int i = remainIntervals - 1; i >= 0; i--) {
            int[] interval = stack.pop();
            for (int j = 0; j < 2; j++)
                mergedIntervals[i][j] = interval[j];
        }
        return mergedIntervals;
    }
}