class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int[] longest = new int[length];
        longest[0] = 1;
        int len = 1;
        int[] d = new int[length + 1];
        d[len] = obstacles[0];
        for (int i = 1; i < length; ++i) {
            if (obstacles[i] >= d[len]) {
                d[++len] = obstacles[i];
                longest[i] = len;
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] <= obstacles[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = obstacles[i];
                longest[i] = pos + 1;
            }
        }
        return longest;
    }
}