class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int length = intervals.length;
        boolean[] remove = new boolean[length];
        for (int i = 0; i < length; i++) {
            int[] interval1 = intervals[i];
            for (int j = i + 1; j < length; j++) {
                int[] interval2 = intervals[j];
                if (interval2[1] <= interval1[1])
                    remove[j] = true;
                if (interval2[0] > interval1[1])
                    break;
            }
        }
        int removeCount = 0;
        for (int i = 0; i < length; i++) {
            if (remove[i])
                removeCount++;
        }
        return length - removeCount;
    }
}