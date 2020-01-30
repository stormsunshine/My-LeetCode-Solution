class Solution {
    public String nextClosestTime(String time) {
        String hourStr = time.substring(0, 2), minuteStr = time.substring(3);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 2; i++) {
            set.add(hourStr.charAt(i) - '0');
            set.add(minuteStr.charAt(i) - '0');
        }
        int[] timeArray = {Integer.parseInt(hourStr), Integer.parseInt(minuteStr)};
        for (int i = 1; i <= 1440; i++) {
            next(timeArray);
            if (isReuse(timeArray, set)) {
                String nextTime = String.format("%02d:%02d", timeArray[0], timeArray[1]);
                return nextTime;
            }
        }
        return time;
    }

    public void next(int[] timeArray) {
        timeArray[1]++;
        if (timeArray[1] >= 60) {
            timeArray[1] %= 60;
            timeArray[0]++;
        }
        if (timeArray[0] >= 24)
            timeArray[0] %= 24;
    }

    public boolean isReuse(int[] timeArray, Set<Integer> set) {
        int hour = timeArray[0], minute = timeArray[1];
        if (!set.contains(hour / 10))
            return false;
        else if (!set.contains(hour % 10))
            return false;
        else if (!set.contains(minute / 10))
            return false;
        else if (!set.contains(minute % 10))
            return false;
        else
            return true;
    }
}