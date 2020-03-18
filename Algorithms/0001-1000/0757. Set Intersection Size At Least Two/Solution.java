class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] != interval2[0])
                    return interval1[0] - interval2[0];
                else
                    return interval2[1] - interval1[1];
            }
        });
        int length = intervals.length;
        int[] remains = new int[length];
        Arrays.fill(remains, 2);
        int size = 0;
        for (int i = length - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];
            int remain = remains[i];
            int intersectionStart = start, intersectionEnd = start + remain;
            for (int j = intersectionStart; j < intersectionEnd; j++) {
                for (int k = 0; k <= i; k++) {
                    if (remains[k] > 0 && j <= intervals[k][1])
                        remains[k]--;
                }
                size++;
            }
        }
        return size;
    }
}