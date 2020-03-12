class Solution {
    public String largestTimeFromDigits(int[] A) {
        int curHour = -1, curMinute = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue;
                    int l = 6 - i - j - k;
                    int hour = A[i] * 10 + A[j], minute = A[k] * 10 + A[l];
                    if (hour <= 23 && minute <= 59) {
                        if (hour > curHour || hour == curHour && minute > curMinute) {
                            curHour = hour;
                            curMinute = minute;
                        }
                    }
                }
            }
        }
        return curHour >= 0 ? String.format("%02d:%02d", curHour, curMinute) : "";
    }
}