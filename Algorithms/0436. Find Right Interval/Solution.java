class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[][] intervalsIndices = new int[length][3];
        for (int i = 0; i < length; i++) {
            intervalsIndices[i][0] = intervals[i][0];
            intervalsIndices[i][1] = intervals[i][1];
            intervalsIndices[i][2] = i;
        }
        Arrays.sort(intervalsIndices, new Comparator<int[]>() {
            public int compare(int[] intervalIndex1, int[] intervalIndex2) {
                if (intervalIndex1[0] != intervalIndex2[0])
                    return intervalIndex1[0] - intervalIndex2[0];
                else
                    return intervalIndex1[2] - intervalIndex2[2];
            }
        });
        int[][] rightIntervalsIndices = new int[length][2];
        for (int i = 0; i < length; i++) {
            rightIntervalsIndices[i][0] = -1;
            int curIntervalEnd = intervalsIndices[i][1];
            for (int j = i + 1; j < length; j++) {
                int nextIntervalStart = intervalsIndices[j][0];
                if (nextIntervalStart >= curIntervalEnd) {
                    rightIntervalsIndices[i][0] = intervalsIndices[j][2];
                    break;
                }
            }
            rightIntervalsIndices[i][1] = intervalsIndices[i][2];
        }
        Arrays.sort(rightIntervalsIndices, new Comparator<int[]>() {
            public int compare(int[] intervalIndex1, int[] intervalIndex2) {
                return intervalIndex1[1] - intervalIndex2[1];
            }
        });
        int[] rightIntervals = new int[length];
        for (int i = 0; i < length; i++)
            rightIntervals[i] = rightIntervalsIndices[i][0];
        return rightIntervals;
    }
}