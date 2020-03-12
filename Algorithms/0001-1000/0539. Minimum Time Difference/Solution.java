class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int size = timePoints.size();
        int minDifference = difference(timePoints.get(0), timePoints.get(size - 1));
        for (int i = 1; i < size; i++) {
            int difference = difference(timePoints.get(i - 1), timePoints.get(i));
            minDifference = Math.min(minDifference, difference);
        }
        return minDifference;
    }

    public int difference(String timePoint1, String timePoint2) {
        int hour1 = Integer.parseInt(timePoint1.substring(0, 2));
        int minute1 = Integer.parseInt(timePoint1.substring(3));
        int hour2 = Integer.parseInt(timePoint2.substring(0, 2));
        int minute2 = Integer.parseInt(timePoint2.substring(3));
        int difference = Math.abs((hour2 - hour1) * 60 + (minute2 - minute1));
        return Math.min(difference, 1440 - difference);
    }
}